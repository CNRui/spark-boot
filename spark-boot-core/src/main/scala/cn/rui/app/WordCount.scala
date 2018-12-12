package cn.rui.app


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import cn.rui.config.ApplicationConfig

@Component
class WordCount @Autowired()(ac: ApplicationConfig) {

  def run(): Unit = {
    val lines = ac.SparkContext.parallelize(Seq("1", "2", "3", "4", "5", "5"))

    val pairs = lines.map { word => (word, 1) }

    val wordCounts = pairs.reduceByKey(_ + _)
    wordCounts.foreach(wordNumberPair => println(wordNumberPair._1 + " : " + wordNumberPair._2))

    println(ac.appName + ac.master)
    ac.SparkContext.stop()

  }

}
