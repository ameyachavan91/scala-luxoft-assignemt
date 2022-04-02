package assignment.sensor.stats.reader

import assignment.sensor.stats.model.SensorDetails

import scala.io.{BufferedSource, Source}

/**
 * Implementation of [[SensorReader]] responsible for reading sales from a CSV file.
 *
 * @param fileName The name of the CSV file to be read.
 */
class SensorCSVReader(val fileName: String) extends SensorReader {

  override def readSensorData(): Seq[SensorDetails] = {
    val fileSource: BufferedSource = Source.fromFile(fileName)

    val listSensorDetails = for {
      line <- fileSource.getLines().drop(1).toVector
      values = line.split(",").map(_.trim)
    } yield SensorDetails(values(0), values(1))

    fileSource.close()
    listSensorDetails
  }

}
