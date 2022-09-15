public class Student {
    String name, stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int matExam, int matVerbal, int fizikExam, int fizikVerbal, int kimyaExam, int kimyaVerbal) {
        float examFactor;
        if (isNoteValid(matExam) && isNoteValid(matVerbal)) {
            examFactor = 1 - this.mat.verbalFactor;
            this.mat.note = (int) (examFactor * matExam + this.mat.verbalFactor * matVerbal);
        }

        if (isNoteValid(fizikExam) && isNoteValid(fizikVerbal)) {
            examFactor = 1 - this.fizik.verbalFactor;
            this.fizik.note = (int) (examFactor * fizikExam + this.fizik.verbalFactor * fizikVerbal);
        }

        if (isNoteValid(kimyaExam) && isNoteValid(kimyaVerbal)) {
            examFactor = 1 - this.kimya.verbalFactor;
            this.kimya.note = (int) (examFactor * kimyaExam + this.kimya.verbalFactor * kimyaVerbal);
        }

    }

    private boolean isNoteValid(int note) {
        return note >= 0 && note <= 100;
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.fizik.note + this.kimya.note + this.mat.note) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}