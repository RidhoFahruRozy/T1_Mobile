// Data class tetap digunakan karena ini standar dasar di Kotlin
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

fun main() {
    // 1. Inisialisasi Data (Minimal 10)
    val daftarMhs = ArrayList<Mahasiswa>()
    daftarMhs.add(Mahasiswa("202401", "Budi Santoso", "Algoritma", 85))
    daftarMhs.add(Mahasiswa("202402", "Ani Wijaya", "Algoritma", 92))
    daftarMhs.add(Mahasiswa("202403", "Citra Dewi", "Algoritma", 68))
    daftarMhs.add(Mahasiswa("202404", "Dani Pratama", "Algoritma", 45))
    daftarMhs.add(Mahasiswa("202405", "Eka Putra", "Algoritma", 75))
    daftarMhs.add(Mahasiswa("202406", "Fajar Ramadhan", "Algoritma", 88))
    daftarMhs.add(Mahasiswa("202407", "Gita Permata", "Algoritma", 70))
    daftarMhs.add(Mahasiswa("202408", "Hadi Saputra", "Algoritma", 55))
    daftarMhs.add(Mahasiswa("202409", "Indah Sari", "Algoritma", 95))
    daftarMhs.add(Mahasiswa("202410", "Joko Susilo", "Algoritma", 62))

    // --- MENAMPILKAN SEMUA DATA ---
    println("DAFTAR NILAI MAHASISWA:")
    for (mhs in daftarMhs) {
        println("NIM: ${mhs.nim} | Nama: ${mhs.nama} | Nilai: ${mhs.nilai}")
    }
    println("--------------------------------------------------")

    // 2 & 3. FILTER LULUS & TIDAK LULUS (Manual menggunakan if-else dalam loop)
    println("\nSTATUS KELULUSAN (Ambang Batas 70):")
    for (i in 0 until daftarMhs.size) {
        val m = daftarMhs[i]
        if (m.nilai >= 70) {
            println("${m.nama} dinyatakan LULUS")
        } else {
            println("${m.nama} dinyatakan TIDAK LULUS")
        }
    }

    // 4, 5, 6. MENCARI RATA-RATA, MAX, DAN MIN (Logika Algoritma Dasar)
    var totalNilai = 0
    var mhsTertinggi = daftarMhs[0]
    var mhsTerendah = daftarMhs[0]

    for (m in daftarMhs) {
        totalNilai += m.nilai // Menghitung total untuk rata-rata
        
        // Cari Tertinggi
        if (m.nilai > mhsTertinggi.nilai) {
            mhsTertinggi = m
        }
        
        // Cari Terendah
        if (m.nilai < mhsTerendah.nilai) {
            mhsTerendah = m
        }
    }
    val rataRata = totalNilai.toDouble() / daftarMhs.size

    println("\nSTATISTIK NILAI:")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${mhsTertinggi.nilai} (${mhsTertinggi.nama})")
    println("Nilai Terendah  : ${mhsTerendah.nilai} (${mhsTerendah.nama})")

    // 7. PENGURUTAN / SORTING (Manual menggunakan Bubble Sort)
    // Mengurutkan dari nilai terbesar ke terkecil
    for (i in 0 until daftarMhs.size - 1) {
        for (j in 0 until daftarMhs.size - i - 1) {
            if (daftarMhs[j].nilai < daftarMhs[j + 1].nilai) {
                // Tukar posisi (Swap)
                val temp = daftarMhs[j]
                daftarMhs[j] = daftarMhs[j + 1]
                daftarMhs[j + 1] = temp
            }
        }
    }
    println("\nURUTAN MAHASISWA BERDASARKAN NILAI (DESC):")
    for (m in daftarMhs) {
        println("${m.nilai} - ${m.nama}")
    }

    // 8 & 9. PENGELOMPOKKAN GRADE & HITUNG JUMLAH (Manual)
    var gradeA = 0; var gradeB = 0; var gradeC = 0; var gradeD = 0; var gradeE = 0
    
    for (m in daftarMhs) {
        if (m.nilai >= 85) {
            gradeA++
        } else if (m.nilai >= 75) {
            gradeB++
        } else if (m.nilai >= 65) {
            gradeC++
        } else if (m.nilai >= 50) {
            gradeD++
        } else {
            gradeE++
        }
    }

    println("\nREKAPITULASI GRADE:")
    println("Grade A: $gradeA mahasiswa")
    println("Grade B: $gradeB mahasiswa")
    println("Grade C: $gradeC mahasiswa")
    println("Grade D: $gradeD mahasiswa")
    println("Grade E: $gradeE mahasiswa")

    // 10. PENCARIAN NAMA (Manual)
    val cariNama = "Indah"
    println("\nHASIL PENCARIAN NAMA '$cariNama':")
    var ditemukan = false
    for (m in daftarMhs) {
        if (m.nama.contains(cariNama)) {
            println("Data ditemukan -> NIM: ${m.nim}, Nama: ${m.nama}, Nilai: ${m.nilai}")
            ditemukan = true
        }
    }
    if (!ditemukan) println("Data tidak ditemukan.")
}