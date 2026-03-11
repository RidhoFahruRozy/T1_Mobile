fun main() {
    println("===== SISTEM PENILAIAN =====")
    println()

    print("Masukkan Nama Mahasiswa: ")
    val nama = readlnOrNull() ?: ""

    fun getValidScore(prompt: String): Int {
        var score: Int
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.toIntOrNull()
            if (input != null && input in 0..100) {
                score = input
                break
            }
            println("Input tidak valid! Harap masukkan angka bulat antara 0 - 100.")
        }
        return score
    }

    val uts = getValidScore("Masukkan Nilai UTS (0-100): ")
    val uas = getValidScore("Masukkan Nilai UAS (0-100): ")
    val tugas = getValidScore("Masukkan Nilai Tugas (0-100): ")

    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    val nilaiBulat = nilaiAkhir.toInt()

    var grade = ""
    var keterangan = ""

    when (nilaiBulat) {
        in 85..100 -> {
            grade = "A"
            keterangan = "Sangat Baik"
        }
        in 70..84 -> {
            grade = "B"
            keterangan = "Baik"
        }
        in 60..69 -> {
            grade = "C"
            keterangan = "Cukup"
        }
        in 50..59 -> {
            grade = "D"
            keterangan = "Kurang"
        }
        in 0..49 -> {
            grade = "E"
            keterangan = "Sangat Kurang"
        }
    }

    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    println("\n===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-------------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")
    println()

    if (status == "LULUS") {
        println("Selamat! Anda dinyatakan LULUS.")
    } else {
        println("Maaf, Anda dinyatakan TIDAK LULUS.")
    }
}