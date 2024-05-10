package hungnvvph32403.fpt.lab2

data class Student(val name: String, val mssv: String, val diemTB: Float, val daTotNghiep: Boolean?, val tuoi: Int?)

class StudentManagement {
    private val studentList = mutableListOf<Student>()

    fun addStudent(student: Student) {
        studentList.add(student)
        println("Sinh viên được thêm thành công.")
    }

    fun updateStudent(mssv: String, updatedStudent: Student) {
        val student = studentList.find { it.mssv == mssv }
        if (student != null) {
            studentList.remove(student)
            studentList.add(updatedStudent)
            println("Thông tin sinh viên đã được cập nhật.")
        } else {
            println("Không tìm thấy sinh viên có MSSV $mssv.")
        }
    }

    fun deleteStudent(mssv: String) {
        val student = studentList.find { it.mssv == mssv }
        if (student != null) {
            studentList.remove(student)
            println("Sinh viên đã được xóa khỏi danh sách.")
        } else {
            println("Không tìm thấy sinh viên có MSSV $mssv.")
        }
    }

    fun viewAllStudents() {
        if (studentList.isEmpty()) {
            println("Danh sách sinh viên rỗng.")
        } else {
            println("Danh sách sinh viên:")
            for (student in studentList) {
                println("MSSV: ${student.mssv}, Tên: ${student.name}, Điểm TB: ${student.diemTB}, Đã tốt nghiệp: ${student.daTotNghiep}, Tuổi: ${student.tuoi}")
            }
        }
    }
}

fun main() {
    val management = StudentManagement()

    val student1 = Student("Nguyễn Văn A", "SV001", 8.5f, true, 22)
    val student2 = Student("Nguyễn Văn B", "SV002", 10f, true, 24)
    val student3 = Student("Nguyễn Văn C", "SV003", 5f, true, 22)
    val student4 = Student("Nguyễn Văn D", "SV004", 6.5f, true, 21)

    management.addStudent(student1)
    management.addStudent(student2)
    management.addStudent(student3)
    management.addStudent(student4)


    val updatedStudent1 = Student("Nguyễn Văn An", "SV001", 8.5f, true, 23)
    management.updateStudent("SV001", updatedStudent1)

    management.deleteStudent("SV004")

    management.viewAllStudents()
}