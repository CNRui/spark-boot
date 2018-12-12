package cn.rui

import cn.rui.app.WordCount
import org.apache.spark.SparkContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.{ComponentScan, Profile, PropertySource}



//@ComponentScan(basePackages = Array("cn.rui"))
//@Profile(Array("dev"))
//@PropertySource(Array("classpath:${spring.profiles.active}/application.properties"))
@SpringBootApplication
class Bootstrap @Autowired()(wc: WordCount) {
  wc.run()
}


object Bootstrap extends App {
  SpringApplication.run(classOf[Bootstrap])
}