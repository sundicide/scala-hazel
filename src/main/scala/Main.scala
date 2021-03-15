import better.files._

object Main {
  def main(args: Array[String]): Unit = {
    val targetDir = "./Downloads/"
    def makeAndGetDir(folderName: String): File =
      (targetDir + folderName)
        .toFile
        .createIfNotExists(true, true)

    val appsDir: File = makeAndGetDir("Apps")
    val audioDir: File = makeAndGetDir("Audio")
    val compressDir: File = makeAndGetDir("Compress")
    val docsDir: File = makeAndGetDir("Docs")
    val fontsDir: File = makeAndGetDir("Fonts")
    val imageDir: File = makeAndGetDir("Image")
    val videoDir: File = makeAndGetDir("Videos")

    val appsExtList: List[String] = List("app", "dmg")
    val audioExtList: List[String] = List("mp3")
    val compressExtList: List[String] = List("rar", "zip", "gz")
    val docsExtList: List[String] = List("csv", "pdf", "pptx", "txt", "xls")
    val fontsExtList: List[String] = List("otf", "ttf")
    val imageExtList: List[String] = List("gif", "jpg", "jpeg", "png", "svg")
    val videoExtList: List[String] = List("mov", "mp4")

    val dir: List[File] = targetDir
      .toFile
      .list
      .toList

    dir.foreach((f: File) => {
      val ext: String = f.name.split("\\.").last

      if (audioExtList.contains(ext))
        f.moveToDirectory(audioDir)
      else if (videoExtList.contains(ext))
        f.moveToDirectory(videoDir)
      else if (docsExtList.contains(ext))
        f.moveToDirectory(docsDir)
      else if (fontsExtList.contains(ext))
        f.moveToDirectory(fontsDir)
      else if (compressExtList.contains(ext))
        f.moveToDirectory(compressDir)
      else if (imageExtList.contains(ext))
        f.moveToDirectory(imageDir)
      else if (appsExtList.contains(ext))
        f.moveToDirectory(appsDir)
    })
  }
}
