# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host:  (MySQL 5.7.21-0ubuntu0.16.04.1)
# Database: gd
# Generation Time: 2018-06-02 03:31:08 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table course
# ------------------------------------------------------------

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL,
  `course_content` text,
  `course_create_date` datetime DEFAULT NULL,
  `course_description` varchar(255) DEFAULT NULL,
  `course_end_date` datetime DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_school_time` varchar(255) DEFAULT NULL,
  `course_start_date` datetime DEFAULT NULL,
  `course_status` varchar(255) DEFAULT NULL,
  `course_teacher_id` varchar(255) DEFAULT NULL,
  `course_title` varchar(255) DEFAULT NULL,
  `course_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;

INSERT INTO `course` (`course_id`, `course_content`, `course_create_date`, `course_description`, `course_end_date`, `course_name`, `course_school_time`, `course_start_date`, `course_status`, `course_teacher_id`, `course_title`, `course_update_date`)
VALUES
	('course05a0ec1b764a422795eb335986e2512c','高数入门','2018-04-26 15:24:58',NULL,'2018-05-10 00:00:00',NULL,NULL,'2018-05-05 00:00:00','1','123','高等数学A',NULL),
	('course193772d708574cd28ccc3fc32a6ef210','教育技术学入门课程','2018-05-04 03:11:44',NULL,'2018-04-26 00:00:00',NULL,NULL,'2018-04-09 00:00:00','2','123','教育技术学导论',NULL),
	('course2711725ab97e4f9c966eb47b80a10d18','<p style=\"text-align: center;\"><b><i><u><strike>社会哲学课程<img src=\"http://localhost:8080/res/layui/images/face/59.gif\" alt=\"[草泥马]\"><img src=\"http://localhost:8080/res/layui/images/face/46.gif\" alt=\"[互粉]\"></strike></u></i></b></p>','2018-04-17 16:29:12',NULL,'2018-05-12 00:00:00',NULL,NULL,'2018-04-15 00:00:00','1','123','马列主义',NULL),
	('course3077a4b4588f4db7be4035da3ac1f3a9','高等数据进阶','2018-04-26 15:25:27',NULL,'2018-05-11 00:00:00',NULL,NULL,'2018-05-05 00:00:00','1','123','高等数学B',NULL),
	('course44773951d39b486eb38a59876048b7b1','计算机入门课程','2018-04-17 14:37:54',NULL,'2018-04-28 00:00:00',NULL,NULL,'2018-04-09 00:00:00','2','123','计算机基础',NULL),
	('course656487eb12664cd48e0762261ea9f1d1','<p><img src=\"http://localhost:8080/res/layui/images/face/32.gif\" alt=\"[困]\"><img src=\"http://localhost:8080/res/layui/images/face/34.gif\" alt=\"[钱]\">office入门</p>','2018-04-17 15:56:18',NULL,'2018-05-11 00:00:00',NULL,NULL,'2018-04-17 00:00:00','1','123','office入门',NULL),
	('course725a774c586e4df7aced5a414449b7a6','','2018-04-17 16:15:53',NULL,'2018-04-28 00:00:00',NULL,NULL,'2018-04-09 00:00:00','2','123','摄影高级',NULL),
	('course78107775c46b4c2ab2e0c93b2abe41d3','多媒体技术基础课程',NULL,NULL,'2018-05-04 00:00:00',NULL,NULL,'2018-04-04 00:00:00','1','123','多媒体技术基础',NULL),
	('course868cf874d4354528a22d9d72aae34c15','<dl class=\"lemmaWgt-lemmaTitle lemmaWgt-lemmaTitle-\"><dd class=\"lemmaWgt-lemmaTitle-title\">\n<h1>线性代数</h1>\n<h2>（数学分支学科）</h2>\n<a class=\"edit-lemma cmn-btn-hover-blue cmn-btn-28 j-edit-link\"><em class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\"></em>编辑</a>\n\n</dd></dl><div class=\"authorityListPrompt\">\n<div class=\"main-content-zj\">\n本词条由<a href=\"http://www.cast.org.cn\" target=\"_blank\" class=\"nslog:7175\">“科普中国”百科科学词条编写与应用工作项目</a>\n审核\n。</div>\n</div>\n<div class=\"lemma-summary\">\n<div class=\"para\">线性代数是数学的一个分支，它的研究对象是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%90%91%E9%87%8F\">向量</a>，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%90%91%E9%87%8F%E7%A9%BA%E9%97%B4\">向量空间</a>（或称线性空间），<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%BA%BF%E6%80%A7%E5%8F%98%E6%8D%A2\">线性变换</a>和有限维的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%BA%BF%E6%80%A7%E6%96%B9%E7%A8%8B%E7%BB%84\">线性方程组</a>。向量空间是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%8E%B0%E4%BB%A3%E6%95%B0%E5%AD%A6\">现代数学</a>的一个重要课题；因而，线性代数被广泛地应用于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8A%BD%E8%B1%A1%E4%BB%A3%E6%95%B0\">抽象代数</a>和<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B3%9B%E5%87%BD%E5%88%86%E6%9E%90\">泛函分析</a>中；通过解析几何，线性代数得以被具体表示。线性代数的理论已被泛化为算子理论。由于科学研究中的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%9D%9E%E7%BA%BF%E6%80%A7%E6%A8%A1%E5%9E%8B\">非线性模型</a>通常可以被近似为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%BA%BF%E6%80%A7%E6%A8%A1%E5%9E%8B\">线性模型</a>，使得线性代数被广泛地应用于自然科学和社会科学中。</div>\n</div>','2018-04-26 15:26:42',NULL,'2018-05-12 00:00:00',NULL,NULL,'2018-04-09 00:00:00','2','123','线性代数',NULL),
	('courseaf6b009a59214659bd6390c0636c4db1','','2018-04-17 16:04:19',NULL,'2018-04-27 00:00:00',NULL,NULL,'2018-04-17 00:00:00','1','123','摄影基础',NULL),
	('coursee0bc049920174b13ad6bd8af177cded0','<p style=\"text-align: center;\">123123123<img src=\"http://localhost:8080/res/layui/images/face/41.gif\" alt=\"[悲伤]\"></p>','2018-04-17 16:26:59',NULL,'2018-04-20 00:00:00',NULL,NULL,'2018-04-11 00:00:00','2','123','123',NULL);

/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table course_attachment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `course_attachment`;

CREATE TABLE `course_attachment` (
  `course_attachment_id` varchar(255) NOT NULL,
  `course_attachment_name` varchar(255) DEFAULT NULL,
  `course_attachment_url` varchar(2000) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `course_attachment` WRITE;
/*!40000 ALTER TABLE `course_attachment` DISABLE KEYS */;

INSERT INTO `course_attachment` (`course_attachment_id`, `course_attachment_name`, `course_attachment_url`, `course_id`)
VALUES
	('courseAttachment175b344f82f14bfc80499c1bb45f470b','filef9bb29465f354db89f701c4e7fd48674###中期检查表-刘亚明.doc','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/file44ff94f8218b42e3a777eb1050f7f18f###filef9bb29465f354db89f701c4e7fd48674###中期检查表-刘亚明.doc','course656487eb12664cd48e0762261ea9f1d1'),
	('courseAttachment296c946c6dd14a9dbfb23f62142f5001','7. 尚硅谷_Java8新特性_创建 Stream.avi','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/file081a84dacaec4906a3897862bb6536aa###7. 尚硅谷_Java8新特性_创建 Stream.avi','course725a774c586e4df7aced5a414449b7a6'),
	('courseAttachment45cb2550d10b48a99f7af9eb877a98b2','尚学堂马士兵_设计模式之_动态代理_00_源码与文档.rar','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/file3261fa20bfeb4ec7a07bfd69bbba5825###尚学堂马士兵_设计模式之_动态代理_00_源码与文档.rar','course193772d708574cd28ccc3fc32a6ef210'),
	('courseAttachment67b20fba34074d24988e3124fe1f0c0f','layer-v3.1.1.zip','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/filede22165a122a4bc5993d69de3f1942ae###layer-v3.1.1.zip','course78107775c46b4c2ab2e0c93b2abe41d3'),
	('courseAttachmentf438463855c9489eaa1fea84669ec7ee','中期检查表-刘亚明.doc','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/filef9bb29465f354db89f701c4e7fd48674###中期检查表-刘亚明.doc','course44773951d39b486eb38a59876048b7b1');

/*!40000 ALTER TABLE `course_attachment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table login_filter_entity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `login_filter_entity`;

CREATE TABLE `login_filter_entity` (
  `login_filter_id` varchar(255) NOT NULL,
  `login_filter_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login_filter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `login_filter_entity` WRITE;
/*!40000 ALTER TABLE `login_filter_entity` DISABLE KEYS */;

INSERT INTO `login_filter_entity` (`login_filter_id`, `login_filter_path`)
VALUES
	('1','/login'),
	('10','/talk'),
	('2','/loginAction'),
	('3','/css'),
	('4','/images'),
	('5','/res'),
	('6','/pictureVerifyCode'),
	('8','/chat'),
	('9','/404');

/*!40000 ALTER TABLE `login_filter_entity` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table message
# ------------------------------------------------------------

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `message_id` varchar(255) NOT NULL,
  `message_content` varchar(255) DEFAULT NULL,
  `message_create_date` datetime DEFAULT NULL,
  `message_status` varchar(255) DEFAULT NULL,
  `message_user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table message_template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `message_template`;

CREATE TABLE `message_template` (
  `message_template_id` varchar(255) NOT NULL,
  `message_template_content` varchar(255) DEFAULT NULL,
  `message_template_create_date` datetime DEFAULT NULL,
  `message_template_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `resource_id` varchar(255) NOT NULL,
  `resource_icon` varchar(255) DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_path` varchar(255) DEFAULT NULL,
  `resource_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;

INSERT INTO `resource` (`resource_id`, `resource_icon`, `resource_name`, `resource_path`, `resource_role`)
VALUES
	('1','&#xe654;','创建课程','/course','2'),
	('2','&#xe63a;','发起互动','/interact','2'),
	('3','&#xe612;','随机点到','/randomSignIn','2'),
	('4','&#xe621;','发布课后作业','/publishWork','2'),
	('5','&#xe618;','批改作业','/checkWork','2'),
	('6','&#xe705;','选课','/lesson','1'),
	('7','&#xe642;','课后作业','/work','1');

/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student_course
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_course`;

CREATE TABLE `student_course` (
  `student_course_id` varchar(255) NOT NULL,
  `course_choose_date` datetime DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `course_status` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;

INSERT INTO `student_course` (`student_course_id`, `course_choose_date`, `course_id`, `course_status`, `student_id`)
VALUES
	('studentCourse304ef4c02fe541628e121155aa511eb7','2018-05-04 09:22:25','course05a0ec1b764a422795eb335986e2512c','1','789'),
	('studentCourse30ec33d08e134c59b1f957922448bc7f','2018-04-18 14:37:42','course193772d708574cd28ccc3fc32a6ef210','1','456'),
	('studentCourse72b0ef2d5dfb45f7beeffadf4c811f66','2018-04-26 10:32:09','course193772d708574cd28ccc3fc32a6ef210','1','789'),
	('studentCourse77cb0e6934604620b7bc7f6392ceee0d','2018-05-04 09:22:02','course05a0ec1b764a422795eb335986e2512c','1','456'),
	('studentCourse910c719c4a914d889b8b4bfbe56058a1','2018-04-18 14:46:27','course2711725ab97e4f9c966eb47b80a10d18','1','456'),
	('studentCoursea30043a1027e4bc8bad0300e67a393d0','2018-05-04 09:22:07','course3077a4b4588f4db7be4035da3ac1f3a9','1','456'),
	('studentCoursefc49ceaa7711429895aa86064e8eb539','2018-05-04 09:22:28','course3077a4b4588f4db7be4035da3ac1f3a9','1','789');

/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student_work
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_work`;

CREATE TABLE `student_work` (
  `student_work_id` varchar(255) NOT NULL,
  `student_work_content` text,
  `student_work_course_id` varchar(255) DEFAULT NULL,
  `student_work_status` varchar(255) DEFAULT NULL,
  `student_work_submit_date` datetime DEFAULT NULL,
  `student_work_user_id` varchar(255) DEFAULT NULL,
  `work_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `student_work` WRITE;
/*!40000 ALTER TABLE `student_work` DISABLE KEYS */;

INSERT INTO `student_work` (`student_work_id`, `student_work_content`, `student_work_course_id`, `student_work_status`, `student_work_submit_date`, `student_work_user_id`, `work_id`)
VALUES
	('studentWork968a44debaa944f4891f1398566577c7','已背诵',NULL,'2','2018-05-02 16:06:56','456','work4deecde2aa004a3daa8f616eb477809e'),
	('studentWorkf6aa4e2e67a54d06af61ca12a37221c1','已背诵',NULL,'2','2018-04-27 15:32:30','456','work4caf246408694138bb378c88a06aae19');

/*!40000 ALTER TABLE `student_work` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student_work_attachment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_work_attachment`;

CREATE TABLE `student_work_attachment` (
  `student_work_attachment_id` varchar(255) NOT NULL,
  `student_work_attachment_name` varchar(255) DEFAULT NULL,
  `student_work_attachment_url` varchar(255) DEFAULT NULL,
  `student_work_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_work_attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `student_work_attachment` WRITE;
/*!40000 ALTER TABLE `student_work_attachment` DISABLE KEYS */;

INSERT INTO `student_work_attachment` (`student_work_attachment_id`, `student_work_attachment_name`, `student_work_attachment_url`, `student_work_id`)
VALUES
	('studentWorkAttachment2e5b3a3dd04948a9a9177f53317bc17e','12.jpg','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/file79564db9fdf44274bfe0eb2bdaed9480%23%23%2312.jpg','studentWorkf6aa4e2e67a54d06af61ca12a37221c1');

/*!40000 ALTER TABLE `student_work_attachment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `user_create_date` datetime DEFAULT NULL,
  `user_grade` varchar(255) DEFAULT NULL,
  `user_icon` varchar(500) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) DEFAULT NULL,
  `user_signature` varchar(500) DEFAULT NULL,
  `user_update_date` datetime DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`user_id`, `major`, `user_create_date`, `user_grade`, `user_icon`, `user_name`, `user_phone`, `user_role`, `user_sex`, `user_signature`, `user_update_date`, `user_password`)
VALUES
	('123',NULL,NULL,NULL,'https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/icon.jpeg','刘亚明','123','2','1','这个人很懒，什么都没有留下',NULL,'202CB962AC59075B964B07152D234B70'),
	('456','教育技术学',NULL,'大二','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/icon.jpeg','申松江','18874588212','1','1','这个人很懒，什么都没有留下',NULL,'202CB962AC59075B964B07152D234B70'),
	('789','教育技术学',NULL,'大四','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/icon.jpeg','吴邦冰','15608471504','1','1','这个人很懒，什么都没有留下',NULL,'202CB962AC59075B964B07152D234B70');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table work
# ------------------------------------------------------------

DROP TABLE IF EXISTS `work`;

CREATE TABLE `work` (
  `work_id` varchar(255) NOT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `work_content` text,
  `work_status` varchar(255) DEFAULT NULL,
  `work_title` varchar(255) DEFAULT NULL,
  `work_create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;

INSERT INTO `work` (`work_id`, `course_id`, `student_id`, `work_content`, `work_status`, `work_title`, `work_create_date`)
VALUES
	('work4caf246408694138bb378c88a06aae19','course193772d708574cd28ccc3fc32a6ef210',NULL,'<p style=\"text-align: center; \"><b><i><u><strike><img src=\"http://localhost:8080/res/layui/images/face/0.gif\" alt=\"[微笑]\">给我背诵94定义</strike></u></i></b></p>','1','背诵94定义','2018-04-18 18:05:19'),
	('work4deecde2aa004a3daa8f616eb477809e','course2711725ab97e4f9c966eb47b80a10d18',NULL,'<p align=\"center\"><strike><u><i><b>哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</b></i></u></strike><br></p>','1','背诵毛泽东思想','2018-04-21 19:42:57'),
	('workd8d87e8917ef46979e546dfef139ccee','course193772d708574cd28ccc3fc32a6ef210',NULL,'完成XXXX1','1','课后作业一','2018-05-02 14:34:55');

/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table work_attachment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `work_attachment`;

CREATE TABLE `work_attachment` (
  `work_attachment_id` varchar(255) NOT NULL,
  `work_attachment_name` varchar(255) DEFAULT NULL,
  `work_attachment_url` varchar(2000) DEFAULT NULL,
  `work_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`work_attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `work_attachment` WRITE;
/*!40000 ALTER TABLE `work_attachment` DISABLE KEYS */;

INSERT INTO `work_attachment` (`work_attachment_id`, `work_attachment_name`, `work_attachment_url`, `work_id`)
VALUES
	('workAttachmentd9357c27a506469f9200796934cb5f82','12.jpg','https://lymbiyesheji.oss-cn-shenzhen.aliyuncs.com/file50bb6c821066468db33bde839ad6ca9a%23%23%2312.jpg','work4caf246408694138bb378c88a06aae19');

/*!40000 ALTER TABLE `work_attachment` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
