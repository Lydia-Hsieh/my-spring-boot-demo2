package com.example.my_spring_boot_demo2.config;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.my_spring_boot_demo2.repository.db1"},
        entityManagerFactoryRef = "db1EntityManagerFactory",
        transactionManagerRef = "db1TransactionManager"
)
public class Db1Config {

    @Resource(name = "db1Datasource")
    private DataSource db1Datasource;

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "db1EntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "db1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(db1Datasource)
                .packages("com.example.my_spring_boot_demo2.entity.db1")
                .persistenceUnit("db1PersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Bean(name = "db1TransactionManager")
    public PlatformTransactionManager db1TransactionManager(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBean = entityManagerFactoryBean(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
