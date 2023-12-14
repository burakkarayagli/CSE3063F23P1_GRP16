import java.util.ArrayList;
import java.util.Arrays;

public class godOfEverything {

        public static void main(String[] args) {
                ArrayList<Course> courses = new ArrayList<Course>();
                ArrayList<MandatoryCourse> mandatoryCourses = new ArrayList<MandatoryCourse>();
                ArrayList<NonTechnicalElectiveCourse> nonTechnicalElectives = new ArrayList<NonTechnicalElectiveCourse>();
                ArrayList<TechnicalElectiveCourse> technicalElectives = new ArrayList<TechnicalElectiveCourse>();
                ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
                ArrayList<Student> students = new ArrayList<Student>();
                ArrayList<Advisor> advisors = new ArrayList<Advisor>();

                String[] locations = { "M2-Z01", "M2-Z02", "M2-Z03", "M2-Z04", "M2-Z04", "M2-Z05", "M2-Z06", "M2-Z07" };
                // Intervals
                ArrayList<TimeInterval> monday = new ArrayList<TimeInterval>();
                monday.add(new TimeInterval("09:30", "10:20", "Monday"));
                monday.add(new TimeInterval("10:30", "11:20", "Monday"));
                monday.add(new TimeInterval("11:30", "12:20", "Monday"));
                monday.add(new TimeInterval("13:00", "13:50", "Monday"));
                monday.add(new TimeInterval("14:00", "14:50", "Monday"));
                monday.add(new TimeInterval("15:00", "15:50", "Monday"));
                monday.add(new TimeInterval("16:00", "16:50", "Monday"));
                ArrayList<TimeInterval> tuesday = new ArrayList<TimeInterval>();
                tuesday.add(new TimeInterval("09:30", "10:20", "Tuesday"));
                tuesday.add(new TimeInterval("10:30", "11:20", "Tuesday"));
                tuesday.add(new TimeInterval("11:30", "12:20", "Tuesday"));
                tuesday.add(new TimeInterval("13:00", "13:50", "Tuesday"));
                tuesday.add(new TimeInterval("14:00", "14:50", "Tuesday"));
                tuesday.add(new TimeInterval("15:00", "15:50", "Tuesday"));
                tuesday.add(new TimeInterval("16:00", "16:50", "Tuesday"));
                ArrayList<TimeInterval> wednesday = new ArrayList<TimeInterval>();
                wednesday.add(new TimeInterval("09:30", "10:20", "Wednesday"));
                wednesday.add(new TimeInterval("10:30", "11:20", "Wednesday"));
                wednesday.add(new TimeInterval("11:30", "12:20", "Wednesday"));
                wednesday.add(new TimeInterval("13:00", "13:50", "Wednesday"));
                wednesday.add(new TimeInterval("14:00", "14:50", "Wednesday"));
                wednesday.add(new TimeInterval("15:00", "15:50", "Wednesday"));
                wednesday.add(new TimeInterval("16:00", "16:50", "Wednesday"));
                ArrayList<TimeInterval> thursday = new ArrayList<TimeInterval>();
                thursday.add(new TimeInterval("09:30", "10:20", "Thursday"));
                thursday.add(new TimeInterval("10:30", "11:20", "Thursday"));
                thursday.add(new TimeInterval("11:30", "12:20", "Thursday"));
                thursday.add(new TimeInterval("13:00", "13:50", "Thursday"));
                thursday.add(new TimeInterval("14:00", "14:50", "Thursday"));
                thursday.add(new TimeInterval("15:00", "15:50", "Thursday"));
                thursday.add(new TimeInterval("16:00", "16:50", "Thursday"));
                ArrayList<TimeInterval> friday = new ArrayList<TimeInterval>();
                friday.add(new TimeInterval("09:30", "10:20", "Friday"));
                friday.add(new TimeInterval("10:30", "11:20", "Friday"));
                friday.add(new TimeInterval("11:30", "12:20", "Friday"));
                friday.add(new TimeInterval("13:00", "13:50", "Friday"));
                friday.add(new TimeInterval("14:00", "14:50", "Friday"));
                friday.add(new TimeInterval("15:00", "15:50", "Friday"));
                friday.add(new TimeInterval("16:00", "16:50", "Friday"));

                // Create Courses
                /// 1. Semester
                Course ata121 = new Course("ATA121", "Atatürk İlkeleri ve İnkılap Tarihi I", "", null, 1, 2, 2);
                Course mbg1201 = new Course("MBG1201", "Introduction to Modern Biology", "", null, 1, 5, 3);
                Course cse1200 = new Course("CSE1200", "Introduction to Computer Engineering", "", null, 1, 4, 3);
                Course cse1241 = new Course("CSE1241", "Computer Programming I", "", null, 1, 6, 4);
                Course math1001 = new Course("MATH1001", "Calculus I", "", null, 1, 6, 2);
                Course phys1101 = new Course("PHYS1001", "Physics I", "", null, 1, 4, 2);
                Course phys1103 = new Course("PHYS1003", "Physics Lab I", "", null, 1, 2, 2);
                Course trd121 = new Course("TRD121", "Türk Dili I", "", null, 1, 2, 2);
                /// 2. Semester
                Course ata122 = new Course("ATA122", "Atatürk İlkeleri ve İnkılap Tarihi II", "", null, 2, 2, 2);
                Course cse1242 = new Course("CSE1241", "Computer Programming II", "", null, 2, 6, 4);
                Course math1002 = new Course("MATH1002", "Calculus II", "", null, 2, 6, 2);
                Course math2256 = new Course("MATH2256", "Linear Algebra for Computer Engineering", "",
                                null, 2, 5, 3);
                Course phys1102 = new Course("PHYS1002", "Physics II", "", null, 2, 4, 2);
                Course phys1104 = new Course("PHYS1004", "Physics Lab II", "", null, 2, 2, 2);
                Course trd122 = new Course("TRD122", "Türk Dili II", "", null, 2, 2, 2);
                // NonTechnicalElective
                Course bus1003 = new Course("BUS1003", "Entrepreneurship and Innovation", "", null, 2, 3, 2);
                // Create TechnicalElective Courses

                courses.add(ata121);
                courses.add(mbg1201);
                courses.add(cse1200);
                courses.add(cse1241);
                courses.add(math1001);
                courses.add(phys1101);
                courses.add(phys1103);
                courses.add(trd121);

                // Create Lecturers
                Lecturer agaoglu = new Lecturer("Mustafa", "Ağaoglu", "mustafa", "mustafaagaoglu", "Doç. Dr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), 10000,
                                "active",
                                new ArrayList<Course>());
                Lecturer ganiz = new Lecturer("Murat Can", "Ganiz", "muratcan", "muratcanganiz", "Doç. Dr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), 10000,
                                "active",
                                new ArrayList<Course>());
                Lecturer boz = new Lecturer("Betül", "Boz", "betul", "boz", "Dr.Öğr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), 10000,
                                "active",
                                new ArrayList<Course>());
                lecturers.add(agaoglu);
                lecturers.add(ganiz);
                lecturers.add(boz);

                // Assign lecturer to courses
                int lecturersNumber = lecturers.size();
                for (int i = 0; i < mandatoryCourses.size(); i++) {
                        MandatoryCourse course = mandatoryCourses.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addCourse(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                        lecturersNumber--;
                }
                lecturersNumber = nonTechnicalElectives.size();
                for (int i = 0; i < nonTechnicalElectives.size(); i++) {
                        NonTechnicalElectiveCourse course = nonTechnicalElectives.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addCourse(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                        lecturersNumber--;
                }
                lecturersNumber = technicalElectives.size();
                for (int i = 0; i < technicalElectives.size(); i++) {
                        TechnicalElectiveCourse course = technicalElectives.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addCourse(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                        lecturersNumber--;
                }

                // Create Students
                Transcript transcript = new Transcript(
                                new ArrayList<Grade>(
                                                Arrays.asList(new Grade(ata121, "AA"), new Grade(mbg1201, "AA"),
                                                                new Grade(cse1200, "AA"),
                                                                new Grade(cse1241, "AA"), new Grade(math1001, "AA"),
                                                                new Grade(phys1101, "AA"),
                                                                new Grade(phys1103, "AA"), new Grade(trd121, "AA"),
                                                                new Grade(ata122, "AA"),
                                                                new Grade(cse1242, "AA"), new Grade(math1002, "AA"),
                                                                new Grade(math2256, "AA"),
                                                                new Grade(phys1102, "AA"), new Grade(phys1104, "AA"),
                                                                new Grade(trd122, "AA"),
                                                                new Grade(bus1003, "AA"))));
                Student kokur = new Student("Hakkı", "Kokur", "hakki", "hakkikokur",
                                "Maltepe/Istanbul", "5315274392", 5, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student karayagli = new Student("Burak", "Karayağlı", "burak",
                                "burakkarayagli",
                                "Kartal/Istanbul", "5312347654", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student akman = new Student("Barış Giray", "Akman", "barisgiray",
                                "barisgirayakman",
                                "Tuzla/Istanbul", "5345274592", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student ozgen = new Student("Efe", "Özgen", "efe", "efeozgen",
                                "Bostancı/Istanbul", "5365544592", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student ozkan = new Student("Musa", "Özkan", "musa", "musaozkan",
                                "Ataşehir/Istanbul", "5305244392", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student unal = new Student("Tamer", "Unal", "tamer", "tamerunal",
                                "Üsküdar/Istanbul", "5375344792", 5, 2021,
                                "", new ArrayList<Course>(), transcript);

                students.add(kokur);
                students.add(karayagli);
                students.add(akman);
                students.add(ozgen);
                students.add(ozkan);
                students.add(unal);

                // Create Advisors
                // fatmacorutergin, alihaydar, mujdat
                Advisor fatmaCorutErgin = new Advisor("Fatma Corut", "Ergin", "fatmacorut", "fatmacorutergin",
                                "Dr.Öğr.Üyesi",
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(0), tuesday.get(1))), 10000,
                                "active", new ArrayList<>(Arrays.asList(kokur, karayagli, akman)));
                Advisor aliHaydar = new Advisor("Ali", "Haydar", "alihaydar", "alihaydar", "Doç.Dr.",
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(2), tuesday.get(3))), 10000,
                                "active", new ArrayList<>(Arrays.asList(ozgen, ozkan, unal)));

                advisors.add(fatmaCorutErgin);
                advisors.add(aliHaydar);

                Json json = new Json();
                json.writeCourses(courses);
                json.writeMandatoryCourses(mandatoryCourses);
                json.writeTechnicalElectiveCourse(technicalElectives);
                json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
                json.writeLecturers(lecturers);
                json.writeStudents(students);
                json.writeAdvisors(advisors);
        }
}
