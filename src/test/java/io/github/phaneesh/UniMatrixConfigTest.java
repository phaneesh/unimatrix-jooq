package io.github.phaneesh;

import org.jooq.SQLDialect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniMatrixConfigTest {


  @Test
  void testDefaultBuilder() {
    UniMatrixConfig factory = UniMatrixConfig.builder()
        .dialect(SQLDialect.DEFAULT)
        .driverClass("Test")
        .user("sa")
        .build();
    assertNotNull(factory.getDialect());
    assertNotNull(factory.getDriverClass());
    assertNotNull(factory.getUser());
    assertEquals(0, factory.getMinPoolSize());
    assertEquals(4, factory.getMaxPoolSize());
    assertEquals(35000, factory.getIdleTimeout());
    assertEquals(45000, factory.getMaxAge());
    assertEquals("SELECT 1;", factory.getTestQuery());
    assertNull(factory.getPassword());
    assertNotNull(factory.toString());
    assertNotEquals(0, factory.hashCode());
  }

  @Test
  void testDefaultConstructor() {
    UniMatrixConfig factory = new UniMatrixConfig();
    assertNull(factory.getDriverClass());
    assertEquals(SQLDialect.MARIADB, factory.getDialect());
    assertNull(factory.getUser());
    assertEquals(0, factory.getMinPoolSize());
    assertEquals(4, factory.getMaxPoolSize());
    assertEquals(35000, factory.getIdleTimeout());
    assertEquals(45000, factory.getMaxAge());
    assertEquals("SELECT 1;", factory.getTestQuery());
    assertNull(factory.getPassword());
    assertNotNull(factory.toString());
    assertNotEquals(0, factory.hashCode());
  }

  @Test
  void testEquals() {
    UniMatrixConfig config = new UniMatrixConfig();
    UniMatrixConfig config1 = new UniMatrixConfig();
    assertEquals(config1, config);
  }

}
