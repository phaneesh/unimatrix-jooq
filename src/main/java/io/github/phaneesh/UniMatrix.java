package io.github.phaneesh;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Builder;
import lombok.Getter;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.Objects;

public class UniMatrix {

  @Getter
  private DSLContext dslContext;

  private HikariDataSource dataSource;

  private final UniMatrixConfig config;
  @Builder
  public UniMatrix(UniMatrixConfig uniMatrixConfig) {
    this.config = uniMatrixConfig;
    init();
  }

  public void close() {
    if(Objects.nonNull(dataSource)) {
      dataSource.close();
    }
  }

  private void init() {
    dslContext = getOrCreateDSLContext();
  }

  public synchronized DSLContext getOrCreateDSLContext() {
    if(!Objects.isNull(dslContext)) {
      return dslContext;
    }
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setAutoCommit(false);
    hikariConfig.setConnectionTimeout(30000);
    hikariConfig.setConnectionTestQuery("SELECT 1");
    hikariConfig.setRegisterMbeans(true);
    hikariConfig.setJdbcUrl(this.config.getUrl());
    hikariConfig.setUsername(this.config.getUser());
    hikariConfig.setPassword(this.config.getPassword());
    hikariConfig.setDriverClassName(this.config.getDriverClass());
    hikariConfig.setMaximumPoolSize(this.config.getMaxPoolSize());
    hikariConfig.setMinimumIdle(this.config.getMinPoolSize());
    hikariConfig.setIdleTimeout(this.config.getIdleTimeout());
    hikariConfig.setPoolName(this.config.getName());
    hikariConfig.setMaxLifetime(this.config.getMaxAge());
    dataSource = new HikariDataSource(hikariConfig);
    dslContext = DSL.using(dataSource, this.config.getDialect());
    return dslContext;
  }
}
