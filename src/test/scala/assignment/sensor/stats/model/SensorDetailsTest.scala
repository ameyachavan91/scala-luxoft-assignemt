package assignment.sensor.stats.model

import org.scalatest.FunSuite

class SensorDetailsTest extends FunSuite {

  test("SensorDetailsTest") {
    val sensorDetails = SensorDetails (
      "S1",
      98
    )

    assert(sensorDetails.sensorId equals "S1")
    assert(sensorDetails.humidity == 98)
  }
}
