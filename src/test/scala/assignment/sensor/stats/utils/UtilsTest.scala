package assignment.sensor.stats.utils

import assignment.sensor.stats.utils.Utils.{fileToObject, getListOfFiles, readFilesToObject}
import org.scalatest.FunSuite

class UtilsTest extends FunSuite {

  test("readFilesToObjectTest") {
    val (listSensorDetails, fileCount) = readFilesToObject("src/test/resources")

    assert(fileCount == 2)
    assert(listSensorDetails.size == 10)
  }

  test("fileToObjectTest") {
    val obj = fileToObject("src/test/resources/leader-1.csv")

    assert(obj.size == 5)
  }

  test("getListOfFilesTest") {
    val (listInputFiles, fileCount) = getListOfFiles("src/test/resources")

    assert(fileCount == 2)
    assert(listInputFiles.size == fileCount)
  }
}
