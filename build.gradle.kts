import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.3.20"
    kotlin("plugin.spring") version "1.3.20"
    //id("com.thinkimi.gradle.MybatisGenerator") version "2.0" //thinkimi提供的 gradle mybatis generator插件
    id("com.jxpanda.generator") version "1.4.11"
}

group = "com.jifenkeji"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    //implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.0.1")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.session:spring-session-data-redis")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.security:spring-security-test")
    // 分页插件
    //implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.2.5")
    // 阿里巴巴数据库连接池
    implementation("com.alibaba:druid:1.0.25")
    //implementation("com.baomidou:mybatis-plus:3.1.2")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.1.2")
    implementation("com.baomidou:mybatis-plus-generator:3.1.2")
    implementation("org.freemarker:freemarker:2.3.28")
    //implementation("p6spy:p6spy:1")

    //swagger
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

//第一种方法，直接使用project的task()方法创建
//第一种配置方法，创建的时候就配置task的group和description
//description就是个说明，类似对注释
task("test4"){
    println("this is helloTask")
}

this.tasks.create("test2") {
}

//第二种方法，使用TaskContainer创建task
this.tasks.create(name= "helloTask2"){
    //第二种配置方式：直接在闭包中配置
    group = "hard"
    description = "task learn"
    println("this is helloTask2")
}

