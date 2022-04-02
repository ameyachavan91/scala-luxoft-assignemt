package assignment.sensor.stats.utils

import assignment.sensor.stats.model.SensorDetails
import assignment.sensor.stats.reader.SensorCSVReader

import java.io.File

object Utils {

  def readFilesToObject(folderPath: String): (Seq[SensorDetails], Int) = {

    val (listInputFiles, fileCount) = getListOfFiles(folderPath)
    val listSensorDetails = listInputFiles
      .map(fileToObject)
      .reduce(_ ++ _)

    (listSensorDetails, fileCount)
  }

  def fileToObject(inputFile: String): Seq[SensorDetails] = {
    new SensorCSVReader(inputFile).readSensorData()
  }

  def getListOfFiles(dir: String): (List[String], Int) = {
    val file = new File(dir)
    val listFiles = file.listFiles
      .filter(_.isFile)
      .filter(_.getName.endsWith("csv"))
      .map(_.getPath).toList

    (listFiles, listFiles.size)
  }
}
