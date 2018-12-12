package cn.rui.config

import cn.rui.properties.JobProperties
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.{Bean, Configuration, PropertySource}
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

import scala.beans.BeanProperty


@Configuration
//@ConfigurationProperties(prefix = "mySpark")
@PropertySource(Array("classpath:${spring.profiles.active}/application.properties"))
class ApplicationConfig {


  @Value("${mySpark.appName}")
  @BeanProperty
  var appName: String = null

  @Value("${mySpark.master}")
  @BeanProperty
  var master: String = null


  @Autowired
  private val jobProperties: JobProperties = null

  @Bean
  def sparkConf(): SparkConf = {
    new SparkConf().setAppName(jobProperties.getAppName).setMaster(jobProperties.getMaster)
  }

  @Bean
  def SparkContext: SparkContext = {
    new SparkContext(sparkConf())
  }

}
