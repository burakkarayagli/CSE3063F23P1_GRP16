package utils;

import java.util.ArrayList;
import java.util.Arrays;

import models.*;
import interfaces.*;
import utils.*;

public class DataInitializer {

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
                courses.add(ata121);
                courses.add(mbg1201);
                courses.add(cse1200);
                courses.add(cse1241);
                courses.add(math1001);
                courses.add(phys1101);
                courses.add(phys1103);
                courses.add(trd121);
                /// 2. Semester
                Course ata122 = new Course("ATA122", "Atatürk İlkeleri ve İnkılap Tarihi II", "", null, 2, 2, 2);
                Course cse1242 = new Course("CSE1242", "Computer Programming II", "", null, 2, 6, 4);
                Course math1002 = new Course("MATH1002", "Calculus II", "", null, 2, 6, 2);
                Course math2256 = new Course("MATH2256", "Linear Algebra for Computer Engineering", "",
                                null, 2, 5, 3);
                Course phys1102 = new Course("PHYS1002", "Physics II", "", null, 2, 4, 2);
                Course phys1104 = new Course("PHYS1004", "Physics Lab II", "", null, 2, 2, 2);
                Course trd122 = new Course("TRD122", "Türk Dili II", "", null, 2, 2, 2);
                courses.add(ata122);
                courses.add(cse1242);
                courses.add(math1002);
                courses.add(math2256);
                courses.add(phys1102);
                courses.add(phys1104);
                courses.add(trd122);
                /// 3. Semester
                Course cse2023 = new Course("CSE2023", "Discrete Computational Structures", "", null, 3, 6, 3);
                Course cse2225 = new Course("CSE2225", "Data Structures", "",
                                new ArrayList<String>(Arrays.asList("CSE1242")), 3, 7, 3);
                Course econ2004 = new Course("ECON2004", "Engineering Economy", "", null, 3, 4, 3);
                Course ee2031 = new Course("EE2031", "Electric Circuits", "",
                                new ArrayList<String>(Arrays.asList("PHYS1102")), 3, 5, 3);
                Course math2055 = new Course("MATH2055", "Differential Equations", "", null, 3, 4, 3);
                Course math2059 = new Course("MATH2059", "Numerical Methods", "",
                                new ArrayList<String>(Arrays.asList("MATH1001")), 3, 4, 3);
                courses.add(cse2023);
                courses.add(cse2225);
                courses.add(econ2004);
                courses.add(ee2031);
                courses.add(math2055);
                courses.add(math2059);
                /// 4. Semester
                Course cse2138 = new Course("CSE2138", "Systems Programming", "", null, 4, 7, 3);
                Course cse2246 = new Course("CSE2246", "Analysis of Algorithms", "",
                                new ArrayList<String>(Arrays.asList("CSE2225")), 4, 6, 3);
                Course cse2260 = new Course("CSE2260", "Principles of Programming Languages", "",
                                new ArrayList<String>(Arrays.asList("CSE1242")), 4, 6, 3);
                Course ee2032 = new Course("EE2032", "Electronics", "", new ArrayList<String>(Arrays.asList("EE2031")),
                                4, 5, 3);
                Course stat2253 = new Course("STAT2253", "Probability and Statistics for Computer Engineering", "",
                                null, 4, 5, 3);
                courses.add(cse2138);
                courses.add(cse2246);
                courses.add(cse2260);
                courses.add(ee2032);
                courses.add(stat2253);

                /// 5. Semester
                Course cse3033 = new Course("CSE3033", "Operating Systems", "",
                                new ArrayList<String>(Arrays.asList("CSE2225")), 5, 7, 3);
                Course cse3055 = new Course("CSE3055", "Database Systems", "",
                                new ArrayList<String>(Arrays.asList("CSE2225")), 5, 7, 3);
                Course cse3063 = new Course("CSE3063", "Object-Oriented Software Design", "",
                                new ArrayList<String>(Arrays.asList("CSE1242")), 5, 5, 3);
                Course cse3215 = new Course("CSE3215", "Digital Logic Design", "", null, 5, 6, 3);
                Course ie3081 = new Course("IE3081", "Modeling and Discrete Simulation", "",
                                new ArrayList<String>(Arrays.asList("STAT2253")), 5, 4, 3);
                courses.add(cse3033);
                courses.add(cse3055);
                courses.add(cse3063);
                courses.add(cse3215);
                courses.add(ie3081);

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
                courses.add(com2202);
                courses.add(cse3044);
                courses.add(cse3264);
                courses.add(cse3038);
                courses.add(cse3048);
                courses.add(ie3235);
                /// 7. semester
                Course cse4297 = new Course("CSE4297", "Engineering Project I", "", null, 7, 5, 4);
                Course cse4074 = new Course("CSE4074", "Computer Networks", "", null, 7, 5, 4);
                Course cse4219 = new Course("CSE4219", "Principles of Embedded System Design", "",
                                new ArrayList<String>(Arrays.asList("CSE3038")), 7, 6, 4);
                Course isg121 = new Course("ISG121", "Work Safety 1", "", null, 7, 2, 2);
                Course cse4288 = new Course("CSE4288", "Introduction to Machine Learning", "",
                                new ArrayList<String>(Arrays.asList("STAT2253", "MATH2256")), 7, 5, 4);
                Course cse4000 = new Course("CSE4000", "Summer Practice ", "", null, 7, 10, 0);
                courses.add(cse4297);
                courses.add(cse4074);
                courses.add(cse4219);
                courses.add(isg121);
                courses.add(cse4288);
                courses.add(cse4000);

                // // 8. Semester
                // Course cse4298 = new Course("CSE4298", "Engineering Project II", "",
                // new ArrayList<String>(Arrays.asList("CSE4297")), 8, 5, 4);
                // Course isg122 = new Course("ISG122", "İş Sağlığı ve Güvenliği II", "",
                // new ArrayList<String>(Arrays.asList("ISG121")), 8, 2, 2);

                // Manadatory Courses
                /// 1. Semester
                MandatoryCourse ata121M = new MandatoryCourse(ata121,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[0], 0);
                MandatoryCourse mbg1201M = new MandatoryCourse(mbg1201,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[1], 0);
                MandatoryCourse cse1200M = new MandatoryCourse(cse1200,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse cse1241M = new MandatoryCourse(cse1241,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse math1001M = new MandatoryCourse(math1001,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                MandatoryCourse phys1101M = new MandatoryCourse(phys1101,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1", null,
                                50, locations[5], 0);
                MandatoryCourse phys1103M = new MandatoryCourse(phys1103,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1", null,
                                50, locations[6], 2);
                MandatoryCourse trd121M = new MandatoryCourse(trd121,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(0), wednesday.get(1))), "1.1",
                                null, 50, locations[7], 0);
                mandatoryCourses.add(ata121M);
                mandatoryCourses.add(mbg1201M);
                mandatoryCourses.add(cse1200M);
                mandatoryCourses.add(cse1241M);
                mandatoryCourses.add(math1001M);
                mandatoryCourses.add(phys1101M);
                mandatoryCourses.add(phys1103M);
                mandatoryCourses.add(trd121M);

                /// 2.Semester
                MandatoryCourse ata122M = new MandatoryCourse(ata122,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1",
                                null, 85, locations[0], 0);
                MandatoryCourse cse1242M = new MandatoryCourse(cse1242,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[1], 0);
                MandatoryCourse math1002M = new MandatoryCourse(math1002,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse math2256M = new MandatoryCourse(math2256,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse phys1102M = new MandatoryCourse(phys1102,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                MandatoryCourse phys1104M = new MandatoryCourse(phys1104,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1", null,
                                50, locations[5], 2);
                MandatoryCourse trd122M = new MandatoryCourse(trd122,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1", null,
                                50, locations[6], 0);
                mandatoryCourses.add(ata122M);
                mandatoryCourses.add(cse1242M);
                mandatoryCourses.add(math1002M);
                mandatoryCourses.add(math2256M);
                mandatoryCourses.add(phys1102M);
                mandatoryCourses.add(phys1104M);
                mandatoryCourses.add(trd122M);

                /// 3.Semester
                MandatoryCourse cse2023M = new MandatoryCourse(cse2023,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[1], 0);
                MandatoryCourse cse2225M = new MandatoryCourse(cse2225,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 0);
                MandatoryCourse econ2004M = new MandatoryCourse(econ2004,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse ee2031M = new MandatoryCourse(ee2031,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse math2055M = new MandatoryCourse(math2055,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                MandatoryCourse math2059M = new MandatoryCourse(math2059,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1", null,
                                50, locations[5], 0);
                mandatoryCourses.add(cse2023M);
                mandatoryCourses.add(cse2225M);
                mandatoryCourses.add(econ2004M);
                mandatoryCourses.add(ee2031M);
                mandatoryCourses.add(math2055M);
                mandatoryCourses.add(math2059M);

                // 4.Semester
                MandatoryCourse cse2138M = new MandatoryCourse(cse2138,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[1], 0);
                MandatoryCourse cse2246M = new MandatoryCourse(cse2246,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 0);
                MandatoryCourse cse2260M = new MandatoryCourse(cse2260,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse ee2032M = new MandatoryCourse(ee2032,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse stat2253M = new MandatoryCourse(stat2253,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                mandatoryCourses.add(cse2138M);
                mandatoryCourses.add(cse2246M);
                mandatoryCourses.add(cse2260M);
                mandatoryCourses.add(ee2032M);
                mandatoryCourses.add(stat2253M);

                // 5.Semester
                MandatoryCourse cse3033M = new MandatoryCourse(cse3033,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[1], 0);
                MandatoryCourse cse3055M = new MandatoryCourse(cse3055,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 0);
                MandatoryCourse cse3063M = new MandatoryCourse(cse3063,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse cse3215M = new MandatoryCourse(cse3215,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse ie3081M = new MandatoryCourse(ie3081,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[4], 0);
                mandatoryCourses.add(cse3033M);
                mandatoryCourses.add(cse3055M);
                mandatoryCourses.add(cse3063M);
                mandatoryCourses.add(cse3215M);
                mandatoryCourses.add(ie3081M);

                // 6.Semester
                MandatoryCourse com2202M = new MandatoryCourse(com2202,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[1], 0);
                MandatoryCourse cse3044M = new MandatoryCourse(cse3044,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 0);
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
                mandatoryCourses.add(com2202M);
                mandatoryCourses.add(cse3044M);
                mandatoryCourses.add(cse3264M);
                mandatoryCourses.add(cse3038M);
                mandatoryCourses.add(cse3048M);
                mandatoryCourses.add(ie3235M);

                // 7.Semester
                MandatoryCourse cse4297M = new MandatoryCourse(cse4297,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                85, locations[1], 0);
                MandatoryCourse cse4000m = new MandatoryCourse(cse4000,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 0);
                MandatoryCourse cse4074M = new MandatoryCourse(cse4074,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[2], 0);
                MandatoryCourse cse4219M = new MandatoryCourse(cse4219,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), tuesday.get(0))), "1.1", null,
                                50, locations[3], 0);
                MandatoryCourse isg121M = new MandatoryCourse(isg121, new ArrayList<TimeInterval>(
                                Arrays.asList(tuesday.get(1), tuesday.get(2), tuesday.get(3), tuesday.get(4))), "1.1",
                                null, 50, locations[4], 0);
                MandatoryCourse cse4288M = new MandatoryCourse(cse4288,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1", null,
                                50, locations[5], 0);
                mandatoryCourses.add(cse4297M);
                mandatoryCourses.add(cse4000m);
                mandatoryCourses.add(cse4074M);
                mandatoryCourses.add(cse4219M);
                mandatoryCourses.add(isg121M);
                mandatoryCourses.add(cse4288M);

                // Technical Elective Courses
                // Course CSE4026
                Course cse4026 = new Course("CSE4026", "Introduction to Robotics and Control Theory", "Elective", null,
                                7, 5, 4);
                TechnicalElectiveCourse cse4026T = new TechnicalElectiveCourse(cse4026,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[1], 165);
                courses.add(cse4026);
                technicalElectives.add(cse4026T);

                // Course CSE4032
                Course cse4032 = new Course("CSE4032", "Introduction to Distributed Systems", "Elective", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4032T = new TechnicalElectiveCourse(cse4032,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), "1.1", null,
                                50, locations[2], 155);
                courses.add(cse4032);
                technicalElectives.add(cse4032T);

                // Course CSE4034
                Course cse4034 = new Course("CSE4034", "Advanced Unix Programming", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4034T = new TechnicalElectiveCourse(cse4034,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(1), tuesday.get(2))), "1.1", null,
                                50, locations[3], 165);
                courses.add(cse4034);
                technicalElectives.add(cse4034T);

                // Course CSE4038
                Course cse4038 = new Course("CSE4038", "Introduction to Parallel Processing", "Elective", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4038T1 = new TechnicalElectiveCourse(cse4038,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(3), thursday.get(4))), "1.1",
                                null, 50, locations[4], 155);
                TechnicalElectiveCourse cse4038T2 = new TechnicalElectiveCourse(cse4038,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(5), thursday.get(6))), "1.2",
                                null, 50, locations[5], 155);
                courses.add(cse4038);
                technicalElectives.add(cse4038T1);
                technicalElectives.add(cse4038T2);

                // Course CSE4040
                Course cse4040 = new Course("CSE4040", "Cloud Computing", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4040T = new TechnicalElectiveCourse(cse4040,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(4), friday.get(5))), "1.1", null,
                                50, locations[6], 165);
                courses.add(cse4040);
                technicalElectives.add(cse4040T);

                // Course CSE4044
                Course cse4044 = new Course("CSE4044", "Software Project Management", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4044T = new TechnicalElectiveCourse(cse4044,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[7], 155);
                courses.add(cse4044);
                technicalElectives.add(cse4044T);

                // Course CSE4053
                Course cse4053 = new Course("CSE4053", "Information Systems: Analysis and Design", "Elective", null, 7,
                                5, 4);
                TechnicalElectiveCourse cse4053T = new TechnicalElectiveCourse(cse4053,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), "1.1", null,
                                50, locations[0], 165);
                courses.add(cse4053);
                technicalElectives.add(cse4053T);

                // Course CSE4056
                Course cse4056 = new Course("CSE4056", "Management of Information Systems", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4056T = new TechnicalElectiveCourse(cse4056,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), "1.1", null,
                                50, locations[1], 155);
                courses.add(cse4056);
                technicalElectives.add(cse4056T);

                // Course CSE4057
                Course cse4057 = new Course("CSE4057", "Information Systems Security", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4057T1 = new TechnicalElectiveCourse(cse4057,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(0), wednesday.get(1))), "1.1",
                                null, 50, locations[2], 165);
                TechnicalElectiveCourse cse4057T2 = new TechnicalElectiveCourse(cse4057,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(6), wednesday.get(0))), "1.2",
                                null, 50, locations[3], 165);
                courses.add(cse4057);
                technicalElectives.add(cse4057T1);
                technicalElectives.add(cse4057T2);

                // Course CSE4058
                Course cse4058 = new Course("CSE4058", "Fundamentals of Electronic Commerce", "Elective", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4058T = new TechnicalElectiveCourse(cse4058,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(0), friday.get(1))), "1.1", null,
                                50, locations[4], 165);
                courses.add(cse4058);
                technicalElectives.add(cse4058T);

                // Course CSE4059
                Course cse4059 = new Course("CSE4059", "Internet Programming", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4059T = new TechnicalElectiveCourse(cse4059,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(2), friday.get(3))), "1.1", null,
                                50, locations[5], 155);
                courses.add(cse4059);
                technicalElectives.add(cse4059T);

                // Course CSE4061
                Course cse4061 = new Course("CSE4061", "Compiler Design", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4061T = new TechnicalElectiveCourse(cse4061,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(5), monday.get(6))), "1.1", null,
                                50, locations[6], 165);
                courses.add(cse4061);
                technicalElectives.add(cse4061T);

                // Course CSE4062
                Course cse4062 = new Course("CSE4062", "Introduction to Data Science and Analytics", "Elective", null,
                                7, 5, 4);
                TechnicalElectiveCourse cse4062T = new TechnicalElectiveCourse(cse4062,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1", null,
                                50, locations[7], 155);
                courses.add(cse4062);
                technicalElectives.add(cse4062T);

                // Course CSE4063
                Course cse4063 = new Course("CSE4063", "Fundamentals of Data Mining", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4063T = new TechnicalElectiveCourse(cse4063,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[0], 165);
                courses.add(cse4063);
                technicalElectives.add(cse4063T);

                // Course CSE4065
                Course cse4065 = new Course("CSE4065", "Introduction to Computational Genomics", "Elective", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4065T = new TechnicalElectiveCourse(cse4065,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(1), thursday.get(2))), "1.1",
                                null, 50, locations[1], 155);
                courses.add(cse4065);
                technicalElectives.add(cse4065T);

                // Course CSE4066
                Course cse4066 = new Course("CSE4066", "Introduction to Cryptography", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4066T = new TechnicalElectiveCourse(cse4066,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(4), thursday.get(5))), "1.1",
                                null, 50, locations[2], 165);
                courses.add(cse4066);
                technicalElectives.add(cse4066T);

                // Course CSE4067
                Course cse4067 = new Course("CSE4067", "Introduction to Blockchain Programming", "Elective", null, 7, 5,
                                4);
                TechnicalElectiveCourse cse4067T = new TechnicalElectiveCourse(cse4067,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(5), friday.get(6))), "1.1", null,
                                50, locations[3], 155);
                courses.add(cse4067);
                technicalElectives.add(cse4067T);

                // Course CSE4070
                Course cse4070 = new Course("CSE4070", "Software Frameworks", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4070T = new TechnicalElectiveCourse(cse4070,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1", null,
                                50, locations[4], 165);
                courses.add(cse4070);
                technicalElectives.add(cse4070T);

                // Course CSE4075
                Course cse4075 = new Course("CSE4075", "Wireless and Mobile Networks", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4075T = new TechnicalElectiveCourse(cse4075,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[5], 155);
                courses.add(cse4075);
                technicalElectives.add(cse4075T);

                // Course CSE4082
                Course cse4082 = new Course("CSE4082", "Artificial Intelligence", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4082T = new TechnicalElectiveCourse(cse4082,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(1), wednesday.get(2))), "1.1",
                                null, 50, locations[6], 165);
                courses.add(cse4082);
                technicalElectives.add(cse4082T);

                // Course CSE4083
                Course cse4083 = new Course("CSE4083", "Computer Graphics", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4083T = new TechnicalElectiveCourse(cse4083,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(0), tuesday.get(1))), "1.1", null,
                                50, locations[7], 155);
                courses.add(cse4083);
                technicalElectives.add(cse4083T);

                // Course CSE4084
                Course cse4084 = new Course("CSE4084", "Multimedia Systems", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4084T = new TechnicalElectiveCourse(cse4084,
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(6), monday.get(0))), "1.1", null,
                                50, locations[0], 165);
                courses.add(cse4084);
                technicalElectives.add(cse4084T);

                // Course CSE4085
                Course cse4085 = new Course("CSE4085", "Human Computer Interaction", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4085T = new TechnicalElectiveCourse(cse4085,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(0), thursday.get(1))), "1.1",
                                null, 50, locations[1], 155);
                courses.add(cse4085);
                technicalElectives.add(cse4085T);

                // Course CSE4086
                Course cse4086 = new Course("CSE4086", "Mobile Device Programming", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4086T = new TechnicalElectiveCourse(cse4086,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(2), friday.get(3))), "1.1", null,
                                50, locations[2], 165);
                courses.add(cse4086);
                technicalElectives.add(cse4086T);

                // Course CSE4217
                Course cse4217 = new Course("CSE4217", "Microprocessors", "Elective", null, 7, 5, 4);
                TechnicalElectiveCourse cse4217T = new TechnicalElectiveCourse(cse4217,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(3), friday.get(4))), "1.1", null,
                                50, locations[3], 155);
                courses.add(cse4217);
                technicalElectives.add(cse4217T);

                // Course CSE4093
                Course cse4093 = new Course("CSE4093", "Special Topics in Computer Engineering I", "Elective", null, 7,
                                5, 4);
                TechnicalElectiveCourse cse4093T = new TechnicalElectiveCourse(cse4093,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(4), tuesday.get(5))), "1.1", null,
                                50, locations[4], 165);
                courses.add(cse4093);
                technicalElectives.add(cse4093T);

                // Course CSE4094
                Course cse4094 = new Course("CSE4094", "Special Topics in Computer Engineering II", "Elective", null, 7,
                                5, 4);
                TechnicalElectiveCourse cse4094T = new TechnicalElectiveCourse(cse4094,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(3), wednesday.get(4))), "1.1",
                                null, 50, locations[5], 155);
                courses.add(cse4094);
                technicalElectives.add(cse4094T);

                // Course CSE4095
                Course cse4095 = new Course("CSE4095", "Special Topics in Computer Engineering III", "Elective", null,
                                7, 5, 4);
                TechnicalElectiveCourse cse4095T = new TechnicalElectiveCourse(cse4095,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(5), wednesday.get(6))), "1.1",
                                null, 50, locations[6], 165);
                courses.add(cse4095);
                technicalElectives.add(cse4095T);

                // Course CSE4096
                Course cse4096 = new Course("CSE4096", "Special Topics in Computer Engineering IV", "Elective", null, 7,
                                5, 4);
                TechnicalElectiveCourse cse4096T = new TechnicalElectiveCourse(cse4096,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(2), thursday.get(3))), "1.1",
                                null, 50, locations[7], 155);
                courses.add(cse4096);
                technicalElectives.add(cse4096T);

                // Non Technical Elective Courses
                Course bus1003 = new Course("BUS1003", "Entrepreneurship and Innovation", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse bus1003N1 = new NonTechnicalElectiveCourse(bus1003,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(1), wednesday.get(2))), "N1",
                                null, 50, locations[4], true);
                NonTechnicalElectiveCourse bus1003N2 = new NonTechnicalElectiveCourse(bus1003,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(3), thursday.get(4))), "N2",
                                null, 50, locations[7], true);
                courses.add(bus1003);
                nonTechnicalElectives.add(bus1003N1);
                nonTechnicalElectives.add(bus1003N2);

                Course bus1004 = new Course("BUS1004", "Strategic Entrepreneurship", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse bus1004N1 = new NonTechnicalElectiveCourse(bus1004,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(3), thursday.get(4))), "1.1",
                                null, 50, locations[7], true);
                courses.add(bus1004);
                nonTechnicalElectives.add(bus1004N1);

                Course bus2005 = new Course("BUS2005", "International Business", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse bus2005N1 = new NonTechnicalElectiveCourse(bus2005,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(1), friday.get(2))), "N1",
                                null, 50, locations[2], true);
                NonTechnicalElectiveCourse bus2005N2 = new NonTechnicalElectiveCourse(bus2005,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "N2",
                                null, 50, locations[1], true);
                courses.add(bus2005);
                nonTechnicalElectives.add(bus2005N1);
                nonTechnicalElectives.add(bus2005N2);

                Course cas1001 = new Course("CAS1001", "Self Management", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas1001N1 = new NonTechnicalElectiveCourse(cas1001,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(4), tuesday.get(5))), "1.1",
                                null, 50, locations[5], true);
                courses.add(cas1001);
                nonTechnicalElectives.add(cas1001N1);

                Course cas1010 = new Course("CAS1010", "Our Biosphere", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas1010N1 = new NonTechnicalElectiveCourse(cas1010,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(6), wednesday.get(0))), "1.1",
                                null, 50, locations[1], true);
                courses.add(cas1010);
                nonTechnicalElectives.add(cas1010N1);

                Course cas1061 = new Course("CAS1061", "Geometric Origami", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas1061N1 = new NonTechnicalElectiveCourse(cas1061,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(6), friday.get(0))), "1.1",
                                null, 50, locations[6], true);
                courses.add(cas1061);
                nonTechnicalElectives.add(cas1061N1);

                Course cas2001 = new Course("CAS2001", "Energy for Physical Activity", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas2001N1 = new NonTechnicalElectiveCourse(cas2001,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "N1",
                                null, 50, locations[0], true);
                NonTechnicalElectiveCourse cas2001N2 = new NonTechnicalElectiveCourse(cas2001,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(0), thursday.get(1))), "N2",
                                null, 50, locations[1], true);
                courses.add(cas2001);
                nonTechnicalElectives.add(cas2001N1);
                nonTechnicalElectives.add(cas2001N2);

                Course cas2002 = new Course("CAS2002", "Human Performance and Nutrition", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas2002N = new NonTechnicalElectiveCourse(cas2002,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(0), tuesday.get(1))), "1.1",
                                null, 50, locations[3], true);
                courses.add(cas2002);
                nonTechnicalElectives.add(cas2002N);

                Course cas2003 = new Course("CAS2003", "Cardiopulmonary Resuscitation and First Aid Basics", "", null,
                                1, 2,
                                2);
                NonTechnicalElectiveCourse cas2003N = new NonTechnicalElectiveCourse(cas2003,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(5), wednesday.get(6))), "1.1",
                                null, 50, locations[7], true);
                courses.add(cas2003);
                nonTechnicalElectives.add(cas2003N);

                Course cas2004 = new Course("CAS2004", "Interpersonal Relations and Communication", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas2004N = new NonTechnicalElectiveCourse(cas2004,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(0), thursday.get(1))), "1.1",
                                null, 50, locations[1], true);
                courses.add(cas2004);
                nonTechnicalElectives.add(cas2004N);

                Course cas2005 = new Course("CAS2005", "Trekking and Orienteering", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas2005N = new NonTechnicalElectiveCourse(cas2005,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(2), tuesday.get(3))), "1.1",
                                null, 50, locations[4], true);
                courses.add(cas2005);
                nonTechnicalElectives.add(cas2005N);

                Course cas3001 = new Course("CAS3001", "Earthquake and Rescue Principles", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas3001N = new NonTechnicalElectiveCourse(cas3001,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(3), friday.get(4))), "1.1",
                                null, 50, locations[2], true);
                courses.add(cas3001);
                nonTechnicalElectives.add(cas3001N);

                Course cas3044 = new Course("CAS3044", "Positive Thinking", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse cas3044N = new NonTechnicalElectiveCourse(cas3044,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(5), thursday.get(6))), "1.1",
                                null, 50, locations[5], true);
                courses.add(cas3044);
                nonTechnicalElectives.add(cas3044N);

                Course comm2060 = new Course("COMM2060", "Communication Models and Techniques", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse comm2060N = new NonTechnicalElectiveCourse(comm2060,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(0), friday.get(1))), "1.1",
                                null, 50, locations[6], true);
                courses.add(comm2060);
                nonTechnicalElectives.add(comm2060N);

                Course fnce3003 = new Course("FNCE3003", "Investment Planning", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse fnce3003N = new NonTechnicalElectiveCourse(fnce3003,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(3), wednesday.get(4))), "1.1",
                                null, 50, locations[3], true);
                courses.add(fnce3003);
                nonTechnicalElectives.add(fnce3003N);

                Course hr1013 = new Course("HR1013", "Career Development", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse hr1013N = new NonTechnicalElectiveCourse(hr1013,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(5), friday.get(6))), "1.1",
                                null, 50, locations[0], true);
                courses.add(hr1013);
                nonTechnicalElectives.add(hr1013N);

                Course hr4001 = new Course("HR4001", "Career Orientation", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse hr4001N = new NonTechnicalElectiveCourse(hr4001,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(2), thursday.get(3))), "1.1",
                                null, 50, locations[2], true);
                courses.add(hr4001);
                nonTechnicalElectives.add(hr4001N);

                Course hss3002 = new Course("HSS3002", "Ethics in Engineering and Science", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse hss3002N = new NonTechnicalElectiveCourse(hss3002,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(5), tuesday.get(6))), "1.1",
                                null, 50, locations[1], true);
                courses.add(hss3002);
                nonTechnicalElectives.add(hss3002N);

                Course ikt1054 = new Course("IKT1054", "Industrial and Economic Sociology", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ikt1054N = new NonTechnicalElectiveCourse(ikt1054,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[4], true);
                courses.add(ikt1054);
                nonTechnicalElectives.add(ikt1054N);

                Course inf1001 = new Course("INF1001", "Information Literacy in Engineering", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse inf1001N = new NonTechnicalElectiveCourse(inf1001,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(0), wednesday.get(1))), "1.1",
                                null, 50, locations[2], true);
                courses.add(inf1001);
                nonTechnicalElectives.add(inf1001N);

                Course law2004 = new Course("LAW2004", "Labor Law", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse law2004N = new NonTechnicalElectiveCourse(law2004,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(2), tuesday.get(3))), "1.1",
                                null, 50, locations[5], true);
                courses.add(law2004);
                nonTechnicalElectives.add(law2004N);

                Course man1001 = new Course("MAN1001", "Principles of Managerial Economics & Financial Management", "",
                                null,
                                1, 2, 2);
                NonTechnicalElectiveCourse man1001N = new NonTechnicalElectiveCourse(man1001,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(2), friday.get(3))), "1.1",
                                null, 50, locations[4], true);
                courses.add(man1001);
                nonTechnicalElectives.add(man1001N);

                Course mgt1021 = new Course("MGT1021", "Design, Innovation and Entrepreneurship", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse mgt1021N = new NonTechnicalElectiveCourse(mgt1021,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(1), wednesday.get(2))), "1.1",
                                null, 50, locations[1], true);
                courses.add(mgt1021);
                nonTechnicalElectives.add(mgt1021N);

                Course mgt3082 = new Course("MGT3082", "Creativity And Innovation Management", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse mgt3082N = new NonTechnicalElectiveCourse(mgt3082,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(4), thursday.get(5))), "1.1",
                                null, 50, locations[6], true);
                courses.add(mgt3082);
                nonTechnicalElectives.add(mgt3082N);

                Course mrk3082 = new Course("MRK3082", "Integrated Marketing Communication", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse mrk3082N = new NonTechnicalElectiveCourse(mrk3082,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(1), friday.get(2))), "1.1",
                                null, 50, locations[3], true);
                courses.add(mrk3082);
                nonTechnicalElectives.add(mrk3082N);

                Course mrk3084 = new Course("MRK3084", "Brand Creation/Branding", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse mrk3084N = new NonTechnicalElectiveCourse(mrk3084,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[0], true);
                courses.add(mrk3084);
                nonTechnicalElectives.add(mrk3084N);

                Course nte1002 = new Course("NTE1002", "Effects of Human Behaviour on Environment", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1002N = new NonTechnicalElectiveCourse(nte1002,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(0), thursday.get(1))), "1.1",
                                null, 50, locations[7], true);
                courses.add(nte1002);
                nonTechnicalElectives.add(nte1002N);

                Course nte1003 = new Course("NTE1003", "The Culture of Radiation Safety", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1003N = new NonTechnicalElectiveCourse(nte1003,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(4), tuesday.get(5))), "1.1",
                                null, 50, locations[1], true);
                courses.add(nte1003);
                nonTechnicalElectives.add(nte1003N);

                Course nte1004 = new Course("NTE1004", "World Cultures", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1004N = new NonTechnicalElectiveCourse(nte1004,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(3), friday.get(4))), "1.1",
                                null, 50, locations[5], true);
                courses.add(nte1004);
                nonTechnicalElectives.add(nte1004N);

                Course nte1006 = new Course("NTE1006",
                                "Basic Principles of Accessibility in Informatics and Technology", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1006N = new NonTechnicalElectiveCourse(nte1006,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(1), wednesday.get(2))), "1.1",
                                null, 50, locations[2], true);
                courses.add(nte1006);
                nonTechnicalElectives.add(nte1006N);

                Course nte1008 = new Course("NTE1008", "Cinema", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1008N = new NonTechnicalElectiveCourse(nte1008,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(3), thursday.get(4))), "1.1",
                                null, 50, locations[6], true);
                courses.add(nte1008);
                nonTechnicalElectives.add(nte1008N);

                Course nte1010 = new Course("NTE1010", "Introduction to Finance for Engineers", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1010N = new NonTechnicalElectiveCourse(nte1010,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[3], true);
                courses.add(nte1010);
                nonTechnicalElectives.add(nte1010N);

                Course nte1011 = new Course("NTE1011", "Business Communication", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1011N = new NonTechnicalElectiveCourse(nte1011,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(5), thursday.get(6))), "1.1",
                                null, 50, locations[0], true);
                courses.add(nte1011);
                nonTechnicalElectives.add(nte1011N);

                Course nte1012 = new Course("NTE1012", "Introduction to Corporate Governance for Engineers", "", null,
                                1, 2,
                                2);
                NonTechnicalElectiveCourse nte1012N = new NonTechnicalElectiveCourse(nte1012,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(0), tuesday.get(1))), "1.1",
                                null, 50, locations[7], true);
                courses.add(nte1012);
                nonTechnicalElectives.add(nte1012N);

                Course nte1013 = new Course("NTE1013", "Business Intelligence for Managers", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1013N = new NonTechnicalElectiveCourse(nte1013,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(3), wednesday.get(4))), "1.1",
                                null, 50, locations[4], true);
                courses.add(nte1013);
                nonTechnicalElectives.add(nte1013N);

                Course nte1014 = new Course("NTE1014", "Introduction to Strategic Human Resources Management", "", null,
                                1, 2,
                                2);
                NonTechnicalElectiveCourse nte1014N = new NonTechnicalElectiveCourse(nte1014,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(0), friday.get(1))), "1.1",
                                null, 50, locations[1], true);
                courses.add(nte1014);
                nonTechnicalElectives.add(nte1014N);

                Course nte1015 = new Course("NTE1015", "Introduction to Leadership & Management for Engineers", "",
                                null, 1,
                                2, 2);
                NonTechnicalElectiveCourse nte1015N = new NonTechnicalElectiveCourse(nte1015,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(2), thursday.get(3))), "1.1",
                                null, 50, locations[6], true);
                courses.add(nte1015);
                nonTechnicalElectives.add(nte1015N);

                Course nte1016 = new Course("NTE1016", "Introduction to Strategy for Engineers", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse nte1016N = new NonTechnicalElectiveCourse(nte1016,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(5), wednesday.get(6))), "1.1",
                                null, 50, locations[2], true);
                courses.add(nte1016);
                nonTechnicalElectives.add(nte1016N);

                Course ob2040 = new Course("OB2040", "Industrial Psychology", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ob2040N = new NonTechnicalElectiveCourse(ob2040,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(3), tuesday.get(4))), "1.1",
                                null, 50, locations[7], true);
                courses.add(ob2040);
                nonTechnicalElectives.add(ob2040N);

                Course ob2041 = new Course("OB2041", "Behavioral Sciences for Engineers", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ob2041N = new NonTechnicalElectiveCourse(ob2041,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(0), wednesday.get(1))), "1.1",
                                null, 50, locations[3], true);
                courses.add(ob2041);
                nonTechnicalElectives.add(ob2041N);

                Course ob3043 = new Course("OB3043", "Organizational Behaviour", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ob3043N = new NonTechnicalElectiveCourse(ob3043,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(0), thursday.get(1))), "1.1",
                                null, 50, locations[5], true);
                courses.add(ob3043);
                nonTechnicalElectives.add(ob3043N);

                Course soc3082 = new Course("SOC3082", "Environmental Sociology", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse soc3082N = new NonTechnicalElectiveCourse(soc3082,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(3), friday.get(4))), "1.1",
                                null, 50, locations[4], true);
                courses.add(soc3082);
                nonTechnicalElectives.add(soc3082N);

                Course yda1001 = new Course("YDA1001", "German for Beginners", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse yda1001N = new NonTechnicalElectiveCourse(yda1001,
                                new ArrayList<TimeInterval>(Arrays.asList(tuesday.get(0), tuesday.get(1))), "1.1",
                                null, 50, locations[6], true);
                courses.add(yda1001);
                nonTechnicalElectives.add(yda1001N);

                Course yda1002 = new Course("YDA1002", "German", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse yda1002N = new NonTechnicalElectiveCourse(yda1002,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[0], true);
                courses.add(yda1002);
                nonTechnicalElectives.add(yda1002N);

                Course yda1003 = new Course("YDA1003", "German Communication", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse yda1003N = new NonTechnicalElectiveCourse(yda1003,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(5), friday.get(6))), "1.1",
                                null, 50, locations[7], true);
                courses.add(yda1003);
                nonTechnicalElectives.add(yda1003N);

                Course yda2001 = new Course("YDA2001", "Seminars in German", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse yda2001N = new NonTechnicalElectiveCourse(yda2001,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(2), thursday.get(3))), "1.1",
                                null, 50, locations[1], true);
                courses.add(yda2001);
                nonTechnicalElectives.add(yda2001N);

                Course ydf1001 = new Course("YDF1001", "French for Beginners", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ydf1001N = new NonTechnicalElectiveCourse(ydf1001,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(4), wednesday.get(5))), "1.1",
                                null, 50, locations[2], true);
                courses.add(ydf1001);
                nonTechnicalElectives.add(ydf1001N);

                Course ydf1002 = new Course("YDF1002", "French", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ydf1002N = new NonTechnicalElectiveCourse(ydf1002,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(4), thursday.get(5))), "1.1",
                                null, 50, locations[3], true);
                courses.add(ydf1002);
                nonTechnicalElectives.add(ydf1002N);

                Course ydi1004 = new Course("YDI1004", "Report Writing in English", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ydi1004N = new NonTechnicalElectiveCourse(ydi1004,
                                new ArrayList<TimeInterval>(Arrays.asList(friday.get(0), friday.get(1))), "1.1",
                                null, 50, locations[6], true);
                courses.add(ydi1004);
                nonTechnicalElectives.add(ydi1004N);

                Course ydis1001 = new Course("YDIS1001", "Spanish for Beginners", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ydis1001N = new NonTechnicalElectiveCourse(ydis1001,
                                new ArrayList<TimeInterval>(Arrays.asList(wednesday.get(2), wednesday.get(3))), "1.1",
                                null, 50, locations[4], true);
                courses.add(ydis1001);
                nonTechnicalElectives.add(ydis1001N);

                Course ydis1002 = new Course("YDIS1002", "Spanish", "", null, 1, 2, 2);
                NonTechnicalElectiveCourse ydis1002N = new NonTechnicalElectiveCourse(ydis1002,
                                new ArrayList<TimeInterval>(Arrays.asList(thursday.get(2), thursday.get(3))), "1.1",
                                null, 50, locations[0], true);
                courses.add(ydis1002);
                nonTechnicalElectives.add(ydis1002N);

                // Create Lecturers
                Lecturer agaoglu = new Lecturer("Mustafa", "Ağaoglu", "mustafa", "mustafaagaoglu", "Doç. Dr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(0), monday.get(1))), 10000,
                                "active", new ArrayList<Course>());
                Lecturer ganiz = new Lecturer("Murat Can", "Ganiz", "muratcan", "muratcanganiz", "Doç. Dr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(2), monday.get(3))), 10000,
                                "active", new ArrayList<Course>());
                Lecturer boz = new Lecturer("Betül", "Boz", "betul", "boz", "Dr.Öğr.",
                                new ArrayList<TimeInterval>(Arrays.asList(monday.get(4), monday.get(5))), 10000,
                                "active", new ArrayList<Course>());
                // new ones
                Lecturer topcuoglu = new Lecturer("Haluk Rahmi", "Topçuğlu", "haluk", "haluk", "Prof. Dr.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer erdem = new Lecturer("Çiğdem Eroğlu", "Erdem", "cigdem", "cigdemerogluerdem", "Prof. Dr.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer alkaya = new Lecturer("Ali Fuat", "Alkaya", "alifuat", "alifuatalkaya", "Prof. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer soyturk = new Lecturer("Müjdat", "Soytürk", "mujdat", "mujdatsoyturk", "Assoc. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer tumer = new Lecturer("Borahan", "Tümer", "borahan", "borahantumer", "Assoc. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer baran = new Lecturer("Mehmet", "Baran", "mehmet", "mehmetbaran", "Asst. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer ergin = new Lecturer("Fatma Corut", "Ergin", "fatma", "fatma.ergin", "Asst. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer korcak = new Lecturer("Ömer", "Korçak", "omer", "omerkorcak", "Assoc. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer ozer = new Lecturer("Ali Haydar", "Özer", "alihaydar", "alihaydarozer", "Asst. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());
                Lecturer arslan = new Lecturer("Sanem", "Arslan", "sanem", "sanemarslan", "Asst. Prof.",
                                new ArrayList<TimeInterval>(), 10000, "active", new ArrayList<Course>());

                lecturers.add(agaoglu);
                lecturers.add(ganiz);
                lecturers.add(boz);
                lecturers.add(topcuoglu);
                lecturers.add(erdem);
                lecturers.add(alkaya);
                lecturers.add(soyturk);
                lecturers.add(tumer);
                lecturers.add(baran);
                lecturers.add(ergin);
                lecturers.add(korcak);
                lecturers.add(ozer);
                lecturers.add(arslan);

                // Assign lecturer to courses
                int lecturersNumber = lecturers.size();
                for (int i = 0; i < mandatoryCourses.size(); i++) {
                        lecturersNumber--;
                        MandatoryCourse course = mandatoryCourses.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addLecturedCourses(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size();
                        }

                }
                lecturersNumber = nonTechnicalElectives.size();
                for (int i = 0; i < nonTechnicalElectives.size(); i++) {
                        lecturersNumber--;
                        NonTechnicalElectiveCourse course = nonTechnicalElectives.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addLecturedCourses(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }

                }
                lecturersNumber = technicalElectives.size();
                for (int i = 0; i < technicalElectives.size(); i++) {
                        lecturersNumber--;
                        TechnicalElectiveCourse course = technicalElectives.get(i);
                        course.setLecturer(lecturers.get(lecturersNumber));
                        lecturers.get(lecturersNumber).addLecturedCourses(course);
                        if (lecturersNumber == 0) {
                                lecturersNumber = lecturers.size() + 1;
                        }
                }

                // Create Students
                Transcript transcript_s1 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s2 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s3 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s4 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s5 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s6 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s7_v1 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");   
                Transcript transcript_s7_v2 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");   
                Transcript transcript_s8_v1 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Transcript transcript_s8_v2 = new Transcript(
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
                                                                new Grade(trd122, "AA"))),
                                "");
                Student kokur = new Student("Hakkı", "Kokur", "hakki", "hakkikokur",
                            "Maltepe/Istanbul", "5315274392", 5, 2020,
                            "", new ArrayList<Course>(), transcript);
                Student karayagli = new Student("Burak", "Karayağlı", "burak", "burakkarayagli",
                                "Kartal/Istanbul", "5312347654", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student akman = new Student("Barış Giray", "Akman", "barisgiray", "barisgirayakman",
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
                Student yilmaz = new Student("Ahmet", "Yilmaz", "ahmet", "ahmetyilmaz",
                                "Kadikoy/Istanbul", "5011223344", 1, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student aydin = new Student("Elif", "Aydin", "elif", "elifaydin",
                                "Sile/Istanbul", "5022334455", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student kaya = new Student("Ayse", "Kaya", "ayse", "aysekaya",
                                "Sisli/Istanbul", "5033445566", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student aksoy = new Student("Mehmet", "Aksoy", "mehmet", "mehmetaksoy",
                                "Silivri/Istanbul", "5044556677", 7, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student celik = new Student("Zeynep", "Celik", "zeynep", "zeynepcelik",
                                "Beykoz/Istanbul", "5055667788", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student demir = new Student("Mustafa", "Demir", "mustafa", "mustafademir",
                                "Atasehir/Istanbul", "5066778899", 4, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student sahin = new Student("Sevgi", "Sahin", "sevgi", "sevgisahin",
                                "Eyupsultan/Istanbul", "5077889900", 8, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student toprak = new Student("Emre", "Toprak", "emre", "emretoprak",
                                "Uskudar/Istanbul", "5088990011", 1, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student yildiz = new Student("Esra", "Yildiz", "esra", "esrayildiz",
                                "Esenler/Istanbul", "5099001122", 6, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student tas = new Student("Ozlem", "Tas", "ozlem", "ozlemtas",
                                "Sariyer/Istanbul", "5100112233", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student yarslan = new Student("Yusuf", "Arslan", "yusuf", "yusufarslan",
                                "Kucukcekmece/Istanbul", "5111223344", 4, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student gunes = new Student("Betul", "Gunes", "betul", "betulgunes",
                                "Maltepe/Istanbul", "5122334455", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student karahan = new Student("Ismail", "Karahan", "ismail", "ismailkarahan",
                                "Buyukcekmece/Istanbul", "5133445566", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student ay = new Student("Ceren", "Ay", "ceren", "cerenay",
                                "Zeytinburnu/Istanbul", "5144556677", 7, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student eren = new Student("Selim", "Eren", "selim", "selimeren",
                                "Besiktas/Istanbul", "5155667788", 8, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student akbas = new Student("Gizem", "Akbas", "gizem", "gizemakbas",
                                "Kagithane/Istanbul", "5166778899", 1, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student yilmazer = new Student("Berk", "Yilmazer", "berk", "berkyilmazer",
                                "Cekmekoy/Istanbul", "5177889900", 6, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student korkmaz = new Student("Ilayda", "Korkmaz", "ilayda", "ilaydakorkmaz",
                                "Bagcilar/Istanbul", "5188990011", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student cetin = new Student("Onur", "Cetin", "onur", "onurcetin",
                                "Tuzla/Istanbul", "5199001122", 4, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student sen = new Student("Gulsen", "Sen", "gulsen", "gulsenSen",
                                "Bakirkoy/Istanbul", "5200112233", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student oguz = new Student("Burak", "Oguz", "burak", "burakoguz",
                                "Bahcelievler/Istanbul", "5211223344", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student kirim = new Student("Sema", "Kirim", "sema", "semakirim",
                                "Beylikduzu/Istanbul", "5222334455", 7, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student selcuk = new Student("Mehmet", "Selcuk", "mehmet", "mehmetselcuk",
                                "Sultanbeyli/Istanbul", "5233445566", 8, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student aslan = new Student("Nazli", "Aslan", "nazli", "nazliaslan",
                                "Umraniye/Istanbul", "5244556677", 1, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student ozturk = new Student("Sercan", "Ozturk", "sercan", "sercanozturk",
                                "Sultangazi/Istanbul", "5255667788", 6, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student ulutas = new Student("Esin", "Ulutas", "esin", "esinulutas",
                                "Beyoglu/Istanbul", "5266778899", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student yildirim = new Student("Riza", "Yildirim", "riza", "rizayildirim",
                                "Basaksehir/Istanbul", "5277889900", 4, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student ekinci = new Student("Sibel", "Ekinci", "sibel", "sibelekinci",
                                "Fatih/Istanbul", "5288990011", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student arikan = new Student("Engin", "Arikan", "engin", "enginArikan",
                                "Sancaktepe/Istanbul", "5299001122", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student karatas = new Student("Eren", "Karatas", "eren", "erenkaratas",
                                "Kadikoy/Istanbul", "5312345678", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student cengiz = new Student("Asli", "Cengiz", "asli", "aslicengiz",
                                "Umraniye/Istanbul", "5323456789", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student sevinc = new Student("Ayse", "Sevinc", "ayse", "aysesevinc",
                                "Sisli/Istanbul", "5345678901", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student kocak = new Student("Ali", "Kocak", "ali", "alikocak",
                                "Bakirkoy/Istanbul", "5356789012", 6, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student onat = new Student("Selin", "Onat", "selin", "selinonat",
                                "Kartal/Istanbul", "5367890123", 1, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student turk = new Student("Kaan", "Turk", "kaan", "kaanturk",
                                "Pendik/Istanbul", "5378901234", 7, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student yilmazoglu = new Student("Deniz", "Yilmazoglu", "deniz", "denizyilmazoglu",
                                "Maltepe/Istanbul", "5389012345", 4, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student acar = new Student("Cem", "Acar", "cem", "cemacar",
                                "Tuzla/Istanbul", "5390123456", 5, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student aygun = new Student("Ebru", "Aygün", "ebru", "ebruaygun",
                                "Kucukcekmece/Istanbul", "5401234567", 3, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student albayrak = new Student("Berkay", "Albayrak", "berkay", "berkayalbayrak",
                                "Beyoglu/Istanbul", "5412345678", 2, 2023,
                                "", new ArrayList<Course>(), transcript);
                Student yigit = new Student("Sibel", "Yigit", "sibel", "sibelyigit",
                                "Avcilar/Istanbul", "5423456789", 5, 2022,
                                "", new ArrayList<Course>(), transcript);
                Student akdogan = new Student("Aysegul", "Akdogan", "aysegul", "aysegulakdogan",
                                "Bagcilar/Istanbul", "5434567890", 6, 2021,
                                "", new ArrayList<Course>(), transcript);
                Student sarikaya = new Student("Ugur", "Sarikaya", "ugur", "ugursarikaya",
                                "Sariyer/Istanbul", "5445678901", 7, 2020,
                                "", new ArrayList<Course>(), transcript);
                Student temiz = new Student("Gizem", "Temiz", "gizem", "gizemtemiz",
                                "Buyukcekmece/Istanbul", "5456789012", 1, 2023,
                                "", new ArrayList<Course>(), transcript);

                students.add(kokur);
                students.add(karayagli);
                students.add(akman);
                students.add(ozgen);
                students.add(ozkan);
                students.add(unal);
                students.add(yilmaz);
                students.add(aydin);
                students.add(kaya);
                students.add(aksoy);
                students.add(celik);
                students.add(demir);
                students.add(sahin);
                students.add(toprak);
                students.add(yildiz);
                students.add(tas);
                students.add(yarslan);
                students.add(gunes);
                students.add(karahan);
                students.add(ay);
                students.add(eren);
                students.add(akbas);
                students.add(yilmazer);
                students.add(korkmaz);
                students.add(cetin);
                students.add(sen);
                students.add(oguz);
                students.add(kirim);
                students.add(selcuk);
                students.add(aslan);
                students.add(ozturk);
                students.add(ulutas);
                students.add(yildirim);
                students.add(ekinci);
                students.add(arikan);
                students.add(karatas);
                students.add(cengiz);
                students.add(sevinc);
                students.add(kocak);
                students.add(onat);
                students.add(turk);
                students.add(yilmazoglu);
                students.add(acar);
                students.add(aygun);
                students.add(albayrak);
                students.add(yigit);
                students.add(akdogan);
                students.add(sarikaya);
                students.add(temiz);

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

                DataUtils json = DataUtils.getInstance();
                json.writeCourses(courses);
                json.writeMandatoryCourses(mandatoryCourses);
                json.writeTechnicalElectiveCourse(technicalElectives);
                json.writeNonTechnicalElectiveCourse(nonTechnicalElectives);
                json.writeLecturers(lecturers);
                json.writeStudents(students);
                json.writeAdvisors(advisors);
        }
}
