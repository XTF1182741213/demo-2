/*
Navicat MySQL Data Transfer

Source Server         : weixinxiaochengxu
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : forum

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-19 20:43:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  `ctime` varchar(32) NOT NULL DEFAULT '2018-02-25 00:00:00',
  `time` varchar(32) NOT NULL DEFAULT '2018-02-25 00:00:00',
  `content` text NOT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `place` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `rank` varchar(100) NOT NULL,
  `sponsor` varchar(100) NOT NULL,
  `target` varchar(32) DEFAULT NULL,
  `aname` varchar(100) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `a_userid` (`userid`),
  CONSTRAINT `a_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('2', '2018年(本部)校素拓聚英考研数学命题老师解析讲座', 'https://www.tengfeistudio.cn/showImg?url=upload/img/37c2d20e-b5bc-4070-b8eb-3643b4f2cd67.jpg', '2018-03-14 00:17:04', '3月19日晚上19:00--21:00', '武忠祥(西交大教授)', null, '一教110', '双创素拓', '校级', '校素拓', '大三学生', '学术讲座', '1');
INSERT INTO `activity` VALUES ('3', '2018年（佛山）公共管理学院三下乡成果展', 'https://www.tengfeistudio.cn/showImg?url=upload/img/1605b707-8eb4-482c-8d4e-41ba44b097a8.jpg', '2018-03-14 00:19:43', '3月16日19:00-21:30', '无', null, '励学楼107', '思德素拓', '院级', '公共管理学院', '公共管理学院大一大二学生', '讲座', '1');
INSERT INTO `activity` VALUES ('4', '2018年（佛山）经济学院班际杯篮球比赛', 'https://www.tengfeistudio.cn/showImg?url=upload/img/a4a16a4b-b9bf-4783-8786-52fd1776fcbe.jpg', '2018-03-14 00:21:28', '3月13日-4月29日', '无', null, '灯光球场', '身心素拓', '院级', '经济学院(佛山)', '经济学院（佛山）全体学生', '比赛', '1');
INSERT INTO `activity` VALUES ('5', '2018年（佛山）工商管理学院第七届团总支文化风采大展', 'https://www.tengfeistudio.cn/showImg?url=upload/img/9217b948-af83-402f-8f6e-904445f31031.jpg', '2018-03-14 00:23:22', '3月13日19:30-21:30', '无', null, '拓新楼232', '无', '院级', '工商管理学院（佛山）', '工商管理学院大一大二全体学生', '展示', '1');
INSERT INTO `activity` VALUES ('6', '2018年（佛山）校青协03月启智学校第一次助残志愿活动', 'https://www.tengfeistudio.cn/showImg?url=upload/img/87b8f245-1ed7-490e-8dba-8a24ed2e6ccf.jpg', '2018-03-14 00:24:51', '3月13日', '无', null, '三水启智学校', '思德素拓', '校级', '校青协（佛山）', '校青协志愿者', '校外活动', '1');
INSERT INTO `activity` VALUES ('7', '2018年（佛山）校青协03月康复中心第一次助残志愿活动', 'https://www.tengfeistudio.cn/showImg?url=upload/img/1c0ca556-0a57-495b-a7b6-b0eecb8319f5.jpg', '2018-03-14 00:26:41', '3月13日', '', null, '三水康复中心', '思德素拓', '校级', '校青协（佛山）', '校青协志愿者', '', '1');
INSERT INTO `activity` VALUES ('8', '2018年（佛山）统计与数学学院升旗仪式', 'https://www.tengfeistudio.cn/showImg?url=upload/img/631960cd-5b26-45f2-b994-b1b2c6fda6d9.jpg', '2018-03-14 00:42:49', '3月12日', '', null, '田径场', '思德素拓', '院级', '统数学院（佛山）', '统计与数学学院（佛山）全体学生', '', '1');
INSERT INTO `activity` VALUES ('13', '2018年（本部）校素拓聚英考研数学命题老师解析讲座', 'https://www.tengfeistudio.cn/showImg?url=upload/img/8f6cc1a4-1f12-40fb-a08a-26e7ca4bd552.jpg', '2018-03-19 09:06:11', '3月19号晚上19:00-21:00', '武忠祥（西安交大教授）', null, '一教110', '双创素拓', '校级', '校素拓', '大三同学', '学术讲座', '1');
INSERT INTO `activity` VALUES ('14', '2018年(本部)公共管理学院19考研讲座', 'https://www.tengfeistudio.cn/showImg?url=upload/img/c7e2f0cd-0f00-464f-8dee-b6edff96d5ae.jpg', '2018-03-19 09:08:42', '3月20号晚上19：00-21：00', '', null, '一教209', '双创素拓', '院级', '公共管理学院', '全体同学', '学术讲座', '1');
INSERT INTO `activity` VALUES ('15', '2018年（本部）图委会广财人•读书事第六期', 'https://www.tengfeistudio.cn/showImg?url=upload/img/ed2538e7-28e7-4dc3-bbd9-8f1bbd57a6f9.jpg', '2018-03-19 09:12:54', '3月20号 15:00-17:00', '邀请黄伟文老师，徐朋老师进行分享', null, '图书馆814', '文化素拓', '校级', '图委会', '全校同学', '读书活动', '1');
INSERT INTO `activity` VALUES ('16', '2018年(本部)经济学院新时代视野座谈会', 'https://www.tengfeistudio.cn/showImg?url=upload/img/e84fe2f3-06f6-473b-80da-a981c160a198.jpg', '2018-03-19 09:14:29', '3月19-20日 19:00-21:00', '', 'https://www.tengfeistudio.cn/showImg?url=upload/img/0a4a4176-4a4a-4443-a194-69bd2ec437af.jpg', '北2-231', '文化素拓', '院级', '经济学院', '全校同学', '文化艺术讲座', '1');
INSERT INTO `activity` VALUES ('25', '2018年（佛山）学生廉洁文化建设协会廉政教育讲座   ', 'https://www.tengfeistudio.cn/showImg?url=upload/img/b3082ada-fc99-4ff1-9826-fd9d6fb31193.jpg', '2018-03-19 20:26:59', '3月19日19:00-22:00', '', 'https://www.tengfeistudio.cn/showImg?url=upload/img/804ba0c3-acea-4b3a-a58e-aac0f3a1ebde.jpg', '三水校区励学楼307 ', '思德素拓', '校级', '广财廉协（佛山）', ' 三水校区全体学生 ', ' 思想品德素质 ', '1');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `topic_id` int(10) NOT NULL DEFAULT '0',
  `reply_id` int(10) NOT NULL DEFAULT '0',
  `reply_name` varchar(32) NOT NULL DEFAULT '0',
  `reply_detail` text NOT NULL,
  `reply_datetime` varchar(32) NOT NULL DEFAULT '2018-03-05 11:17:00',
  `reply_picture` varchar(100) NOT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reply_ibfk_1` (`topic_id`),
  KEY `reply_userid` (`userid`),
  CONSTRAINT `reply_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reply_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '1', 'xiaofei', '评论试下', '2018-03-14 00:31:28', 'https://www.tengfeistudio.cn/showImg?url=upload/img/c5d71608-e61b-4161-ae73-b7a98ca03299.jpg', '1');
INSERT INTO `reply` VALUES ('2', '1', '1', 'enen', '我来评论下', '2018-03-14 00:39:17', 'https://www.tengfeistudio.cn/showImg?url=upload/img/25b9fc66-abf3-4c41-bc42-9f0078838cc4.jpg', '2');
INSERT INTO `reply` VALUES ('3', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:13', '', '2');
INSERT INTO `reply` VALUES ('4', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:13', 'https://www.tengfeistudio.cn/showImg?url=upload/img/ca3d2943-ad0f-45e8-910f-df396249cb42.jpg', '2');
INSERT INTO `reply` VALUES ('5', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:13', '', '2');
INSERT INTO `reply` VALUES ('6', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:14', '', '2');
INSERT INTO `reply` VALUES ('7', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:14', '', '2');
INSERT INTO `reply` VALUES ('8', '2', '2', 'enen', 'Ffggg', '2018-03-14 01:52:14', '', '2');
INSERT INTO `reply` VALUES ('9', '2', '2', 'xiaofei', 'Chhf', '2018-03-14 02:08:55', '', '1');
INSERT INTO `reply` VALUES ('10', '7', '7', 'aa', '评论一下', '2018-03-14 08:12:48', 'https://www.tengfeistudio.cn/showImg?url=upload/img/6fb1af8f-4241-4bb0-8f7f-881d17936378.jpg', '8');
INSERT INTO `reply` VALUES ('11', '15', '15', 'xiaofei', '阿迪斯发发的', '2018-03-14 19:04:52', 'https://www.tengfeistudio.cn/showImg?url=upload/img/802bedbc-ef5e-42de-96d2-95da56e93cd3.jpg', '1');
INSERT INTO `reply` VALUES ('12', '15', '15', 'xiaofei', '啊手动阀', '2018-03-14 19:12:20', '', '1');
INSERT INTO `reply` VALUES ('13', '15', '15', 'xiaofei', 'jjjjjjj', '2018-03-14 21:08:57', 'https://www.tengfeistudio.cn/showImg?url=upload/img/2dfeea50-ab1f-4da8-a3de-5fbffa3ed1a2.jpg', '1');
INSERT INTO `reply` VALUES ('14', '10', '10', 'xiaofei', 'hhhh', '2018-03-14 21:43:40', 'https://www.tengfeistudio.cn/showImg?url=upload/img/c384f17e-2db5-411e-830c-476184a7d2d0.jpeg', '1');
INSERT INTO `reply` VALUES ('15', '15', '15', 'xiaofei', 'lll', '2018-03-14 21:59:53', 'https://www.tengfeistudio.cn/showImg?url=upload/img/3ba922fb-1ac3-4f65-82ed-a70d55aa6b3c.jpeg', '1');
INSERT INTO `reply` VALUES ('16', '15', '15', 'xiaofei', 'ttt', '2018-03-14 22:01:20', 'https://www.tengfeistudio.cn/showImg?url=upload/img/9eb58af6-3060-453e-a044-e61a9a8da64b.jpg', '1');
INSERT INTO `reply` VALUES ('17', '14', '14', 'xiaofei', 'yyy', '2018-03-14 22:02:44', 'https://www.tengfeistudio.cn/showImg?url=upload/img/430375c1-7db6-4438-b421-85bd2d2357d1.jpg', '1');
INSERT INTO `reply` VALUES ('18', '14', '14', 'xiaofei', 'eeee', '2018-03-14 22:07:26', 'https://www.tengfeistudio.cn/showImg?url=upload/img/3abbf645-4b90-41e5-9e0b-b72fd70bb74f.jpeg', '1');
INSERT INTO `reply` VALUES ('19', '13', '13', 'xiaofei', 'eeee', '2018-03-14 22:08:23', 'https://www.tengfeistudio.cn/showImg?url=upload/img/2688397e-4e87-42b4-950e-c18bff23dc18.jpeg', '1');
INSERT INTO `reply` VALUES ('20', '14', '14', 'xiaofei', '需补功课', '2018-03-14 22:09:43', 'https://www.tengfeistudio.cn/showImg?url=upload/img/3a7ccf3a-4adb-4991-890e-a899eb2111e0.jpg', '1');
INSERT INTO `reply` VALUES ('21', '15', '15', 'fei', '聊聊天', '2018-03-14 22:39:03', 'https://www.tengfeistudio.cn/showImg?url=upload/img/786f349c-cd7f-422d-a1c9-c87ebc5b5dbb.jpg', '15');
INSERT INTO `reply` VALUES ('22', '15', '15', '', 'asdf', '2018-03-15 18:51:55', '', '12');
INSERT INTO `reply` VALUES ('23', '15', '15', 'xiaofei', 'adfsfd', '2018-03-15 19:24:37', '', '1');
INSERT INTO `reply` VALUES ('24', '15', '15', 'xiaofei', 'ppppppp', '2018-03-15 19:27:12', 'https://www.tengfeistudio.cn/showImg?url=upload/img/4c6fb83f-b363-4ae4-b231-4e2a95050c7e.jpeg', '1');
INSERT INTO `reply` VALUES ('25', '14', '14', 'enen', '现在可以评论了', '2018-03-15 19:32:46', 'https://www.tengfeistudio.cn/showImg?url=upload/img/b4c71faa-0a53-4209-863f-077e92d588ed.jpg', '2');
INSERT INTO `reply` VALUES ('26', '23', '23', '666', '没有图片的评论', '2018-03-16 19:41:13', '', '16');
INSERT INTO `reply` VALUES ('27', '22', '22', '666', '4444444', '2018-03-16 19:57:21', '', '16');
INSERT INTO `reply` VALUES ('28', '22', '22', '666', '4444444', '2018-03-16 19:57:40', 'https://www.tengfeistudio.cn/showImg?url=upload/img/80df1451-b65b-4e06-8c85-ddffa2a8119c.jpeg', '16');
INSERT INTO `reply` VALUES ('29', '24', '24', '嘻嘻', '点这里', '2018-03-16 23:29:54', '', '9');
INSERT INTO `reply` VALUES ('30', '28', '28', '666', '哈哈哈', '2018-03-18 10:22:33', 'https://www.tengfeistudio.cn/showImg?url=upload/img/b49a5a97-1f79-4bbe-a6b6-e42ddc835c98.jpeg', '16');
INSERT INTO `reply` VALUES ('32', '23', '23', 'xiaofei', '1233', '2018-03-18 11:33:22', '', '1');
INSERT INTO `reply` VALUES ('33', '22', '22', '666', 'jjj', '2018-03-18 11:41:01', '', '16');
INSERT INTO `reply` VALUES ('36', '27', '27', 'xiaofei', '33333', '2018-03-18 13:08:22', '', '1');
INSERT INTO `reply` VALUES ('37', '25', '25', 'xiaofei', '到处已有', '2018-03-18 13:20:44', '', '1');
INSERT INTO `reply` VALUES ('38', '25', '25', 'xiaofei', 'hhh', '2018-03-18 13:21:22', '', '1');
INSERT INTO `reply` VALUES ('39', '19', '19', 'xiaofei', '真的吗', '2018-03-18 13:22:36', '', '1');
INSERT INTO `reply` VALUES ('40', '21', '21', 'xiaofei', '5555', '2018-03-18 13:23:04', '', '1');
INSERT INTO `reply` VALUES ('47', '44', '44', 'xiaofei', 'jjjjjjjj', '2018-03-19 09:43:30', '', '1');
INSERT INTO `reply` VALUES ('48', '44', '44', 'xiaofei', '呵呵哈哈哈', '2018-03-19 11:29:48', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5ef79c5b-ef80-4268-97f9-779932eb56b0.jpg', '1');
INSERT INTO `reply` VALUES ('49', '46', '46', 'xiaofei', '发挥好', '2018-03-19 11:45:53', 'https://www.tengfeistudio.cn/showImg?url=upload/img/a75c2074-56ec-42d0-86a9-63b8eca8ed68.jpg', '1');
INSERT INTO `reply` VALUES ('50', '46', '46', 'xiaofei', 'fhhj', '2018-03-19 11:57:00', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5c4bad19-9060-4233-ac73-0dead0ae5d25.jpg', '1');
INSERT INTO `reply` VALUES ('52', '49', '49', 'xiaofei', '啊手动阀', '2018-03-19 12:15:37', 'https://www.tengfeistudio.cn/showImg?url=upload/img/679479fe-2f44-4eb8-b7e8-40f60e129562.jpeg', '1');
INSERT INTO `reply` VALUES ('53', '50', '50', 'xiaofei', 'ggggggg', '2018-03-19 20:08:34', 'https://www.tengfeistudio.cn/showImg?url=upload/img/c8c15035-6dc1-41d7-85d0-65ad2deb2db6.jpg', '1');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `detail` text NOT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `datetime` varchar(32) NOT NULL DEFAULT '2018-03-05 10:57:00',
  `view` int(10) DEFAULT '0',
  `reply` int(10) DEFAULT '0',
  `locked` tinyint(1) DEFAULT '0',
  `sticky` tinyint(1) DEFAULT '0',
  `userid` int(11) NOT NULL,
  `praise` int(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userId` (`userid`),
  CONSTRAINT `userId` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '测试贴', null, '希望可以发布了', 'https://www.tengfeistudio.cn/showImg?url=upload/img/73b27fdb-c2ea-4c44-82e6-6a6f11fee367.jpg', '2018-03-14 00:28:27', '0', '0', '0', '0', '1', '3');
INSERT INTO `topic` VALUES ('2', '斤斤计较急急急急急急', null, '古古怪怪', 'https://www.tengfeistudio.cn/showImg?url=upload/img/2e86a92e-995e-42ba-bc34-5c45b86824e5.jpeg', '2018-03-14 00:46:36', '0', '0', '0', '0', '2', '4');
INSERT INTO `topic` VALUES ('7', '', null, '有时候会失灵，我也不知为什么', '', '2018-03-14 08:08:43', '0', '0', '0', '0', '1', '4');
INSERT INTO `topic` VALUES ('8', '应该行吧', null, '内容不能为空', 'https://www.tengfeistudio.cn/showImg?url=upload/img/f403d080-3744-4035-8a47-a0ae3f857a92.jpg', '2018-03-14 08:14:24', '0', '0', '0', '0', '8', '12');
INSERT INTO `topic` VALUES ('9', '', null, '试水', 'https://www.tengfeistudio.cn/showImg?url=upload/img/79c7cad0-48de-415d-802e-3bdc8430e92b.jpg', '2018-03-14 08:50:33', '0', '0', '0', '0', '2', '6');
INSERT INTO `topic` VALUES ('10', '', null, '', 'https://www.tengfeistudio.cn/showImg?url=upload/img/38532338-2c07-419a-a38c-74dd4dc93580.jpg', '2018-03-14 17:51:57', '0', '0', '0', '0', '2', '1');
INSERT INTO `topic` VALUES ('13', '', null, 'Fgg', '', '2018-03-14 18:30:34', '0', '0', '0', '0', '2', '6');
INSERT INTO `topic` VALUES ('14', '', null, '', '', '2018-03-14 18:32:34', '0', '0', '0', '0', '2', '7');
INSERT INTO `topic` VALUES ('15', 'Dgh', null, 'undefined', 'https://www.tengfeistudio.cn/showImg?url=upload/img/89e49ed6-804d-4976-af03-bc7ad3a6ef74.jpg', '2018-03-14 18:58:33', '0', '0', '0', '0', '2', '1');
INSERT INTO `topic` VALUES ('19', '666', null, 'undefined', 'https://www.tengfeistudio.cn/showImg?url=upload/img/cd12a268-bbbd-4efb-ac82-8df6880e0f05.jpeg', '2018-03-15 19:58:34', '0', '0', '0', '0', '16', '2');
INSERT INTO `topic` VALUES ('21', '55555555', null, 'undefined', 'https://www.tengfeistudio.cn/showImg?url=upload/img/e94791a4-96cd-42fd-aa81-0d4517384a65.jpg', '2018-03-15 20:04:26', '0', '0', '0', '0', '16', '1');
INSERT INTO `topic` VALUES ('22', '44444', null, 'undefined', '', '2018-03-15 20:04:56', '0', '0', '0', '0', '16', '1');
INSERT INTO `topic` VALUES ('23', '5555', null, '555555', 'https://www.tengfeistudio.cn/showImg?url=upload/img/91697d5e-f63f-4bd1-8484-8a9f9c8b4f8a.jpg', '2018-03-15 20:05:50', '0', '0', '0', '0', '16', '2');
INSERT INTO `topic` VALUES ('24', '66666', null, '6666', 'https://www.tengfeistudio.cn/showImg?url=upload/img/87f3f2f6-d844-4990-912a-36710e6bf279.jpg', '2018-03-15 20:18:49', '0', '0', '0', '0', '16', '0');
INSERT INTO `topic` VALUES ('25', '到此一游', null, '', '', '2018-03-16 09:56:12', '0', '0', '0', '0', '17', '0');
INSERT INTO `topic` VALUES ('27', '没有图片', '单身狗的日常', '恩饿呢恩恩', '', '2018-03-16 20:11:26', '0', '0', '0', '0', '16', '1');
INSERT INTO `topic` VALUES ('28', '', '四六级', '', 'https://www.tengfeistudio.cn/showImg?url=upload/img/00d9c7cb-9e2f-4374-acbf-45b25375cf1c.jpeg', '2018-03-16 20:12:07', '0', '0', '0', '0', '16', '1');
INSERT INTO `topic` VALUES ('44', '滚滚滚滚滚', '四楼', '呵呵哈哈哈', 'https://www.tengfeistudio.cn/showImg?url=upload/img/e541a8cc-d66f-474c-bd53-f7a63a21d105.jpg', '2018-03-19 09:20:20', '0', '0', '0', '0', '19', '3');
INSERT INTO `topic` VALUES ('46', '', '电话号', '放个假', 'https://www.tengfeistudio.cn/showImg?url=upload/img/ffe7fe54-561c-4440-a074-29204fadcf54.jpg', '2018-03-19 11:45:14', '0', '0', '0', '0', '1', '0');
INSERT INTO `topic` VALUES ('47', '就是说', '说的话', '上海市', '', '2018-03-19 11:59:24', '0', '0', '0', '0', '1', '0');
INSERT INTO `topic` VALUES ('49', '', '', '从v这种', 'https://www.tengfeistudio.cn/showImg?url=upload/img/9f232dbb-fc8b-4530-99ac-7e27cfb83d74.jpg', '2018-03-19 12:10:50', '0', '0', '0', '0', '1', '1');
INSERT INTO `topic` VALUES ('50', '', '', '啊手动阀', 'https://www.tengfeistudio.cn/showImg?url=upload/img/3af698b7-b3b2-421b-bb8c-46d406930bfd.jpg', '2018-03-19 12:16:18', '0', '0', '0', '0', '1', '3');
INSERT INTO `topic` VALUES ('51', 'jjjjjjj', 'jjjjjjj', 'jjjjj', 'https://www.tengfeistudio.cn/showImg?url=upload/img/1bdf561a-2213-4293-ba20-8713c940e280.jpeg', '2018-03-19 20:09:00', '0', '0', '0', '0', '1', '0');
INSERT INTO `topic` VALUES ('52', '', '', 'hhhhhh', 'https://www.tengfeistudio.cn/showImg?url=upload/img/283e8fd8-6c5a-4dc8-9ced-a4044227fac9.jpg', '2018-03-19 20:09:22', '0', '0', '0', '0', '1', '0');

-- ----------------------------
-- Table structure for typelist
-- ----------------------------
DROP TABLE IF EXISTS `typelist`;
CREATE TABLE `typelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ArticleTypeID` int(11) DEFAULT NULL,
  `ArticleTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of typelist
-- ----------------------------
INSERT INTO `typelist` VALUES ('1', '0', '全部');
INSERT INTO `typelist` VALUES ('2', '3132', '运营日报');
INSERT INTO `typelist` VALUES ('3', '875', '操作指南');
INSERT INTO `typelist` VALUES ('4', '2038', '常见问题');
INSERT INTO `typelist` VALUES ('5', '2033', '微赞故事');
INSERT INTO `typelist` VALUES ('6', '1', '更新进度');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `phone` bigint(11) DEFAULT NULL,
  `cardpassword` varchar(32) DEFAULT NULL,
  `card` bigint(20) DEFAULT NULL,
  `realname` varchar(50) DEFAULT '某同学',
  `regdate` varchar(32) NOT NULL DEFAULT '2018-02-25 00:00:00',
  `state` int(1) NOT NULL DEFAULT '1',
  `icon` varchar(100) DEFAULT 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png',
  `level` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `card` (`card`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaofei', '123456', '1182741213@163.com', '135366428907', null, '15251104218', '某同学', '2018-03-14 00:05:07', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/c72d383c-9de5-430c-86f9-4b7df74b7482.jpeg', '1');
INSERT INTO `user` VALUES ('2', 'enen', '123456', '', null, null, null, '小弟', '2018-03-14 00:32:58', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/07e8f592-121d-4475-9bff-0af27b6fe103.jpg', '1');
INSERT INTO `user` VALUES ('6', 'feifei', '123', null, null, null, null, '某同学', '2018-03-14 01:06:14', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('7', '123', '123', null, null, null, null, '某同学', '2018-03-14 01:56:58', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('8', 'aa', 'aa', '', null, null, null, '某同学', '2018-03-14 08:11:37', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/5a8b002e-dd7f-4950-8ba1-92a83c4b7904.jpg', '1');
INSERT INTO `user` VALUES ('9', '嘻嘻', 'xtfldn', null, null, null, null, '某同学', '2018-03-14 08:40:38', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('12', '', '', null, null, null, null, '某同学', '2018-03-14 08:47:47', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('14', 'aaa', 'aaa', null, null, null, null, '某同学', '2018-03-14 13:12:01', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('15', 'fei', '123', '', null, null, null, '飞机', '2018-03-14 22:36:36', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/929fc2d2-3641-4d21-ab0f-92827e692a29.jpg', '1');
INSERT INTO `user` VALUES ('16', '666', '666', '', null, null, null, '777777', '2018-03-15 19:56:30', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/04ddf6f3-0eb5-4c7d-8880-63eaf7966b7b.jpg', '1');
INSERT INTO `user` VALUES ('17', 'chilamhhhh', '19960911', null, null, null, null, '某同学', '2018-03-16 09:55:31', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/img/5-5.png', '1');
INSERT INTO `user` VALUES ('19', '321', '321', '', null, null, null, '某同学', '2018-03-19 09:19:29', '1', 'https://www.tengfeistudio.cn/showImg?url=upload/icon/icons/a3e8724a-3e6a-456d-a812-91732c2bddfe.jpg', '1');
