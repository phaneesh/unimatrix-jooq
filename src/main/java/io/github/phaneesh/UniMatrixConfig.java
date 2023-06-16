package io.github.phaneesh;

import lombok.*;
import org.jooq.SQLDialect;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class UniMatrixConfig {


  @Builder.Default
  private String name = "unimatrix";

  private String url;

  private String database;

  private String driverClass;

  private String user;

  private String password;

  @Builder.Default
  private SQLDialect dialect = SQLDialect.MYSQL;

  @Builder.Default
  private int maxPoolSize = 4;

  @Builder.Default
  private int minPoolSize = 0;

  @Builder.Default
  private int idleTimeout = 35000;

  @Builder.Default
  private int connectionTimout = 35000;

  @Builder.Default
  private int maxAge = 45000;

  @Builder.Default
  private int jdbcBatchSize = 100;

  @Builder.Default
  private boolean generateStatistics = false;

  @Builder.Default
  private int slowQueryThreshold = 15;

}
