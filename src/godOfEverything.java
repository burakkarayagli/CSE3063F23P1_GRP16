import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

                /// 6. semester
                Course com2202 = new Course("COM2202", "Technical Communication & Entrepreneurship", "", null, 6, 2, 2);
                Course cse3044 = new Course("CSE3044", "Software Engineering", "",
                                new ArrayList<String>(Arrays.asList("CSE3055")), 6, 7, 5);
                Course cse3264 = new Course("CSE3264", "Formal Languages and Automata Theory", "",
                                new ArrayList<String>(Arrays.asList("CSE2023")), 6, 5, 4);
                Course cse3038 = new Course("CSE3038", "Computer Organization", "",
                                new ArrayList<String>(new ArrayList<>(Arrays.asList("CSE2138", "CSE3215"))), 6, 7, 6);
                Course cse3048 = new Course("CSE3048", "Introduction to Signals and Systems", "",
                                new ArrayList<String>(Arrays.asList("MATH2055")), 6, 5, 4);
                Course ie3235 = new Course("IE3235", "Operations Research", "",
                                new ArrayList<String>(Arrays.asList("MATH2256")), 6, 4, 2);

                /// 7. semester
                Course cse4297 = new Course("CSE4297", "Engineering Project I", "", null, 7, 5, 4);
                Course cse4074 = new Course("CSE4074", "Computer Networks", "", null, 7, 5, 4);
                Course cse4219 = new Course("CSE4219", "Principles of Embedded System Design", "",
                                new ArrayList<String>(Arrays.asList("CSE3038")), 7, 6, 4);
                Course isg121 = new Course("ISG121", "Work Safety 1", "", null, 7, 2, 2);
                Course cse4288 = new Course("CSE4288", "Introduction to Machine Learning", "",
                                new ArrayList<String>(Arrays.asList("STAT2253", "MATH2256")), 7, 5, 4);
                Course cse4000 = new Course("CSE4000", "Summer Practice ", "", null, 7, 10, 0);

                // Manadatory Courses
                MandatoryCourse com2202M = new MandatoryCourse(com2202,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                50, locations[0], 0);
                MandatoryCourse cse3044M = new MandatoryCourse(cse3044,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[1], 0);
                MandatoryCourse cse3264M = new MandatoryCourse(cse3264,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse cse3038M = new MandatoryCourse(cse3038,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse cse3048M = new MandatoryCourse(cse3048,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                MandatoryCourse ie3235M = new MandatoryCourse(ie3235,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1", null,
                                50, locations[5], 0);
                MandatoryCourse cse4297M = new MandatoryCourse(cse4297,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1", null,
                                50, locations[6], 0);
                MandatoryCourse cse4074M = new MandatoryCourse(cse4074,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(0), wednesday.get(1))), "1.1",
                                null, 50, locations[0], 0);

                // Technical Elective Courses
                Course cse4026 = new Course("CSE4026", "Introduction to Robotics and Control Theory", "", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4026T = new TechnicalElectiveCourse(cse4026,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[1], 165);
                Course cse4040 = new Course("CSE4040", "Cloud Computing", "", null, 7, 5, 4);
                TechnicalElectiveCourse cse4040T = new TechnicalElectiveCourse(cse4040,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[2], 155);
                // Non Technical Elective Courses
                Course nte1008 = new Course("NTE1008", "Cinema", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1008N = new NonTechnicalElectiveCourse(nte1008,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(6), thursday.get(0))), "1.1",
                                null, 50, locations[3], true);
                Course yda1001 = new Course("YDA1001", "German for Beginners", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse yda1001N = new NonTechnicalElectiveCourse(yda1001,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(1), thursday.get(2))), "1.1",
                                null, 50, locations[4], false);

                // NonTechnicalElective
                Course bus1003 = new Course("BUS1003", "Entrepreneurship and Innovation", "", null, 2, 3, 2);
                // Create TechnicalElective Courses

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
                        Mandatory course = mandatoryCourses.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addCourse(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                        lecturersNumber--;
                }
                lecturersNumber = nonTechnicalElectives.size();
                for (int i = 0; i < nonTechnicalElectives.size(); i++) {
                        NonTechnicalElective course = nonTechnicalElectives.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addCourse(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                        lecturersNumber--;
                }
                lecturersNumber = technicalElectives.size();
                for (int i = 0; i < technicalElectives.size(); i++) {
                        TechnicalElective course = technicalElectives.get(i);
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
                // Student kokur = new Student("Hakkı", "Kokur", "hakki", "hakkikokur",
                // "Maltepe/Istanbul", "5315274392", 5, 2020,
                // false, new ArrayList<Course>(), transcript);
                // Student karayagli = new Student("Burak", "Karayağlı", "burak",
                // "burakkarayagli",
                // "Kartal/Istanbul", "5312347654", 5, 2021,
                // false, new ArrayList<Course>(), transcript);
                // Student akman = new Student("Barış Giray", "Akman", "barisgiray",
                // "barisgirayakman",
                // "Tuzla/Istanbul", "5345274592", 5, 2021,
                // false, new ArrayList<Course>(), transcript);
                // Student ozgen = new Student("Efe", "Özgen", "efe", "efeozgen",
                // "Bostancı/Istanbul", "5365544592", 5, 2021,
                // false, new ArrayList<Course>(), transcript);
                // Student ozkan = new Student("Musa", "Özkan", "musa", "musaozkan",
                // "Ataşehir/Istanbul", "5305244392", 5, 2021,
                // false, new ArrayList<Course>(), transcript);
                // Student unal = new Student("Tamer", "Unal", "tamer", "tamerunal",
                // "Üsküdar/Istanbul", "5375344792", 5, 2021,
                // false, new ArrayList<Course>(), transcript);

                // Create Advisors
                // fatmacorutergin, alihaydar, mujdat

                mandatoryCourses.add(ata121);
                mandatoryCourses.add(mbg1201);
                mandatoryCourses.add(cse1200);
                mandatoryCourses.add(cse1241);
                mandatoryCourses.add(math1001);
                mandatoryCourses.add(phys1101);
                mandatoryCourses.add(phys1103);
                mandatoryCourses.add(trd121);

                Json json = new Json();
                json.writeMandatories(mandatoryCourses);
        }
}
