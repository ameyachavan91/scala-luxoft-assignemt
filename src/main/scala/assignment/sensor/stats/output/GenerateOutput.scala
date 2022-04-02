package assignment.sensor.stats.output

import assignment.sensor.stats.model.SensorDetails

object GenerateOutput {

  def getAverageFromList(sensorDetails: Seq[SensorDetails]): Double = {
    val totalHumidity: Int = sensorDetails.map(_.humidity.toString.toInt).sum
    val averageResult: Int = totalHumidity / sensorDetails.size
    averageResult
  }

  def getNanCount(sensorDetails: Seq[SensorDetails]): Int = {
    sensorDetails.count(sensorData => sensorData.humidity.equals("NaN"))
  }

  def findAllNanValues(withNan: Map[String, Seq[SensorDetails]]): Iterable[String] = {
    withNan.map(sensorData => (sensorData._1, sensorData._2.size, getNanCount(sensorData._2)))
      .filter(count => count._2 == count._3)
      .map(_._1)
  }

  def generateOutput(listSensorDetails: Seq[SensorDetails], fileCount: Int): Unit = {

    println("Num of processed files: " + fileCount)
    println("Num of processed measurements: " + listSensorDetails.size)
    println("Num of failed measurements: " + listSensorDetails.count(sensorData => sensorData.humidity.equals("NaN")))

    val woNan = listSensorDetails.filterNot(sensorData => sensorData.humidity.equals("NaN"))
    val listGroupData: Iterable[Seq[SensorDetails]] = woNan.groupBy(_.sensorId).values

    println("sensor-id,min,avg,max")
    listGroupData.foreach(sensorDetails => {
      val avg = getAverageFromList(sensorDetails)
      val min = sensorDetails.minBy(_.humidity.toString.toInt)
      val max = sensorDetails.maxBy(_.humidity.toString.toInt)
      println(min.sensorId + "," + min.humidity + "," + avg + "," + max.humidity)
    })

    val withNan = listSensorDetails.groupBy(_.sensorId)

    findAllNanValues(withNan)
      .foreach(sensorData => println(s"$sensorData,NaN,NaN,NaN"))

  }
}
