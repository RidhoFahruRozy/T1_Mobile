fun main() {
    println("===== SISTEM PENILAIAN =====")
    println()

    print("Masukkan Nama Mahasiswa: ")
    val nama = readlnOrNull() ?: ""

    // Fungsi bantuan untuk memastikan input berupa angka dan berada di range 0-100
    fun getValidScore(prompt: String): Int {
        var score: Int
        while (true) {
            print(prompt)
            val input = readlnOrNull()
            if (input.isNullOrBlank()) {
                println("Input tidak boleh kosong! Harap masukkan angka bulat antara 0 - 100.")
                continue
            }
            val number = input.toIntOrNull()
            if (number != null && number in 0..100) {
                score = number
                break
            }
            println("Input tidak valid! Harap masukkan angka bulat antara 0 - 100.")
        }
        return score
    }

    val uts = getValidScore("Masukkan Nilai UTS (0-100): ")
    val uas = getValidScore("Masukkan Nilai UAS (0-100): ")
    val tugas = getValidScore("Masukkan Nilai Tugas (0-100): ")

    // 1. Menghitung nilai akhir dengan bobot sesuai instruksi
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    // 2. Konversi nilai akhir ke huruf dan keterangan menggunakan when
    val nilaiBulat = nilaiAkhir.toInt()

    var grade = ""
    var keterangan = ""

    when (nilaiBulat) {
        in 85..100 -> {
            grade = "A"
            keterangan = "Sangat Baik"
        }
        in 75..84 -> {
            grade = "B"
            keterangan = "Baik"
        }
        in 65..74 -> {
            grade = "C"
            keterangan = "Cukup"
        }
        in 55..64 -> {
            grade = "D"
            keterangan = "Kurang"
        }
        in 0..54 -> {
            grade = "E"
            keterangan = "Sangat Kurang"
        }
    }

    // 3. Menentukan status kelulusan (Lulus jika nilai >= 60)
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // Menampilkan Output sesuai dengan contoh yang diharapkan
    println("\n===== HASIL PENILAIAN =====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("-------------------------------")
    println("Nilai Akhir : ${String.format("%.2f", nilaiAkhir)}")
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