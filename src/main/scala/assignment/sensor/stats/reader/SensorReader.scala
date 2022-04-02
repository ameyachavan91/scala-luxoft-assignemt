package assignment.sensor.stats.reader

import assignment.sensor.stats.model.SensorDetails

trait SensorReader {

  def readSensorData(): Seq[SensorDetails]
}
