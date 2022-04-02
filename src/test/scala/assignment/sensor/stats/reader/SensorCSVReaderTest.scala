package assignment.sensor.stats.reader

import assignment.sensor.stats.model.SensorDetails
import org.scalatest.FunSuite

class SensorCSVReaderTest extends FunSuite {

  test("readSensorDataTest") {
    val sensorCSVReader: Seq[SensorDetails] = new SensorCSVReader("src/test/resources/leader-1.csv").readSensorData()

    assert(sensorCSVReader.size == 5)
  }
}
