package assignment.sensor.stats

import assignment.sensor.stats.output.GenerateOutput.generateOutput
import assignment.sensor.stats.utils.Utils.readFilesToObject

object SensorStatsApp {

  def main(args: Array[String]): Unit = {

    Console.print("Hello world!")

    if (args.isEmpty) {
      println("please pass input file path as an argument")
      System.exit(1)
    }

    val inputFolderPath: String = args(0)

    val (listSensorDetails, fileCount) = readFilesToObject(inputFolderPath)

    generateOutput(listSensorDetails, fileCount)
  }
}
