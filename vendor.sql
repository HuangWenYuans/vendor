/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : vendor

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 26/02/2020 19:35:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart`  (
  `cart_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE,
  INDEX `userid`(`user_id`) USING BTREE,
  CONSTRAINT `t_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cart
-- ----------------------------
INSERT INTO `t_cart` VALUES (87, 7, 7);
INSERT INTO `t_cart` VALUES (120, 2, 1);

-- ----------------------------
-- Table structure for t_cart_vendor
-- ----------------------------
DROP TABLE IF EXISTS `t_cart_vendor`;
CREATE TABLE `t_cart_vendor`  (
  `cart_id` int(11) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  INDEX `FKhucliita0ucf3mban4axaae0b`(`vendor_id`) USING BTREE,
  INDEX `FKfnhqgb51hk445xylknhkqed0v`(`cart_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of t_cart_vendor
-- ----------------------------
INSERT INTO `t_cart_vendor` VALUES (87, 1);
INSERT INTO `t_cart_vendor` VALUES (120, 1);

-- ----------------------------
-- Table structure for t_consignee
-- ----------------------------
DROP TABLE IF EXISTS `t_consignee`;
CREATE TABLE `t_consignee`  (
  `consignee_id` int(10) NOT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  `consignee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consignee_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consignee_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `default` int(1) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`consignee_id`) USING BTREE,
  INDEX `userid`(`user_id`) USING BTREE,
  CONSTRAINT `t_consignee_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_consignee
-- ----------------------------
INSERT INTO `t_consignee` VALUES (1, 2, '黄文源', '江西省宜春市袁州区', '18270631410', 1);
INSERT INTO `t_consignee` VALUES (2, 3, '张三', '江西省南昌市红谷滩', '15454651322', 0);

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `goods_id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_price` decimal(10, 2) NULL DEFAULT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (1, 2.50, '冰红茶', '/assets/img/manufacturer/goods_1.jpg');
INSERT INTO `t_goods` VALUES (2, 3.00, '雪碧', '/assets/img/manufacturer/goods_2.jpg');
INSERT INTO `t_goods` VALUES (3, 3.50, '可乐', '/assets/img/manufacturer/goods_3.jpg');
INSERT INTO `t_goods` VALUES (4, 2.50, '七喜', '/assets/img/manufacturer/goods_4.jpg');
INSERT INTO `t_goods` VALUES (5, 4.00, '水蜜桃', '/assets/img/manufacturer/goods_5.jpg');
INSERT INTO `t_goods` VALUES (6, 3.50, '东鹏特饮', '/assets/img/manufacturer/goods_6.jpg');
INSERT INTO `t_goods` VALUES (7, 4.00, '蜂蜜柚子茶', '/assets/img/manufacturer/goods_7.jpg');
INSERT INTO `t_goods` VALUES (8, 4.00, '绿茶', '/assets/img/manufacturer/goods_8.jpg');
INSERT INTO `t_goods` VALUES (9, 6.00, '红牛', '/assets/img/manufacturer/goods_9.jpg');
INSERT INTO `t_goods` VALUES (10, 4.00, '脉动', '/assets/img/manufacturer/goods_10.jpg');
INSERT INTO `t_goods` VALUES (11, 4.00, '加多宝', '/assets/img/manufacturer/goods_11.jpg');
INSERT INTO `t_goods` VALUES (12, 3.50, '美年达', '/assets/img/manufacturer/goods_12.jpg');
INSERT INTO `t_goods` VALUES (13, 5.00, '小茗同学', '/assets/img/manufacturer/goods_13.jpg');
INSERT INTO `t_goods` VALUES (14, 5.00, '王老吉', '/assets/img/manufacturer/goods_14.jpg');
INSERT INTO `t_goods` VALUES (15, 6.00, '荔枝爽', '/assets/img/manufacturer/goods_15.jpg');
INSERT INTO `t_goods` VALUES (16, 7.00, '战马', '/assets/img/manufacturer/goods_16.jpg');

-- ----------------------------
-- Table structure for t_install_infor
-- ----------------------------
DROP TABLE IF EXISTS `t_install_infor`;
CREATE TABLE `t_install_infor`  (
  `install_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `symbol_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `installer_id` int(10) NULL DEFAULT NULL,
  `install_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `install_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  PRIMARY KEY (`install_id`) USING BTREE,
  INDEX `t_install_infro_ibfk_1`(`user_id`) USING BTREE,
  INDEX `t_install_infro_ibfk_2`(`symbol_id`) USING BTREE,
  INDEX `installer_id`(`installer_id`) USING BTREE,
  CONSTRAINT `t_install_infor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_install_infor_ibfk_3` FOREIGN KEY (`installer_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_install_infor_ibfk_4` FOREIGN KEY (`symbol_id`) REFERENCES `t_symbol` (`symbol_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_install_infor
-- ----------------------------
INSERT INTO `t_install_infor` VALUES (95, 2, 'a724f9cd-2db2-47c4-8890-25f52f9fe274', 3, '2019-07-12 00:00:00', 0);

-- ----------------------------
-- Table structure for t_maintain_infor
-- ----------------------------
DROP TABLE IF EXISTS `t_maintain_infor`;
CREATE TABLE `t_maintain_infor`  (
  `maintain_id` int(10) NOT NULL AUTO_INCREMENT,
  `symbol_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  `maintain_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `maintain_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `maintainer_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`maintain_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `vendor_id`(`symbol_id`) USING BTREE,
  INDEX `maintainer_id`(`maintainer_id`) USING BTREE,
  CONSTRAINT `t_maintain_infor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_maintain_infor_ibfk_2` FOREIGN KEY (`symbol_id`) REFERENCES `t_symbol` (`symbol_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_maintain_infor_ibfk_3` FOREIGN KEY (`maintainer_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `amount` decimal(10, 2) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `orderdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `userid`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (92, 2, 40000.00, 0, '2019-07-04 23:01:29');

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem`  (
  `orderitem_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) NULL DEFAULT NULL,
  `vendor_id` int(10) NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`orderitem_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `vendor_Id`(`vendor_id`) USING BTREE,
  CONSTRAINT `FKb86588iv6n8i61kba1dxg39w8` FOREIGN KEY (`vendor_id`) REFERENCES `t_vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_orderitem_ibfk_2` FOREIGN KEY (`vendor_id`) REFERENCES `t_vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES (97, 92, 1, 2);

-- ----------------------------
-- Table structure for t_replenishment_prompt
-- ----------------------------
DROP TABLE IF EXISTS `t_replenishment_prompt`;
CREATE TABLE `t_replenishment_prompt`  (
  `rep_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `symbol_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goods_id` int(10) NULL DEFAULT NULL,
  `replenishment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `replenishment_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  PRIMARY KEY (`rep_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `vendor_id`(`symbol_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `t_replenishment_prompt_ibfk_3` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_replenishment_prompt
-- ----------------------------
INSERT INTO `t_replenishment_prompt` VALUES (3, -1, '1', 1, '2019-06-25 22:48:07', 0);
INSERT INTO `t_replenishment_prompt` VALUES (4, -1, '1', 1, '2019-06-25 22:51:14', 0);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '厂商');
INSERT INTO `t_role` VALUES (2, '顾客');
INSERT INTO `t_role` VALUES (3, '安装人员');
INSERT INTO `t_role` VALUES (4, '运维人员');

-- ----------------------------
-- Table structure for t_symbol
-- ----------------------------
DROP TABLE IF EXISTS `t_symbol`;
CREATE TABLE `t_symbol`  (
  `symbol_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vendor_id` int(10) NULL DEFAULT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  INDEX `FKjanqehi9t2itews644906e5rd`(`vendor_id`) USING BTREE,
  INDEX `symbol_id`(`symbol_id`) USING BTREE,
  CONSTRAINT `FKjanqehi9t2itews644906e5rd` FOREIGN KEY (`vendor_id`) REFERENCES `t_vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_symbol
-- ----------------------------
INSERT INTO `t_symbol` VALUES ('dce0dc49-4e3c-49a8-b457-2fb0dcec40c8', 1, 2);
INSERT INTO `t_symbol` VALUES ('a724f9cd-2db2-47c4-8890-25f52f9fe274', 1, 2);

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `task_id` int(10) NOT NULL AUTO_INCREMENT,
  `vendor_id` int(10) NULL DEFAULT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  `fix_date` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `task_status` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  PRIMARY KEY (`task_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `vendor_id`(`vendor_id`) USING BTREE,
  CONSTRAINT `t_task_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_task_ibfk_2` FOREIGN KEY (`vendor_id`) REFERENCES `t_vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(1) NULL DEFAULT NULL,
  `role_id` int(10) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'manufacturer', '$2a$10$0Rtc9/4pYpsE.Q3cH9ZyquJvNAgJBJAqA08z7zpS9T48or/EgZ3Pi', '厂商', NULL, 1, 1);
INSERT INTO `t_user` VALUES (2, 'customer', '$2a$10$bhOzDaU4Zhsig5g67jDT4OpbfTXPFpawwzhU1QbFUKukzfM4tn5NO', '顾客', NULL, 1, 2);
INSERT INTO `t_user` VALUES (3, 'installer', '$2a$10$7TgOZyrwD2qZrYtE1mujsONU3pQEiIxCFYeOBc1jN8rr5GyqsN1oq', '安装人员', NULL, 1, 3);
INSERT INTO `t_user` VALUES (4, 'maintainer', '$2a$10$Y9fwWJ6gUrQgqsruHF0N2.IZhoW9Vb0Q0GHh.NDqSAOMpTcICu7CC', '运维人员', NULL, 1, 4);
INSERT INTO `t_user` VALUES (7, 'admin', '$2a$10$XMTLprdPiNeHJ9L1j625Z.toSPp8.XGFlgIvJEDYIwUIiKXMHe1/W', 'admin', NULL, 1, 2);

-- ----------------------------
-- Table structure for t_vendor
-- ----------------------------
DROP TABLE IF EXISTS `t_vendor`;
CREATE TABLE `t_vendor`  (
  `vendor_id` int(10) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int(10) NULL DEFAULT NULL,
  `detail` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(10) NULL DEFAULT NULL,
  `pricture1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pricture2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pricture3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pricture4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`vendor_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `t_vendor_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_vendortype` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_vendor
-- ----------------------------
INSERT INTO `t_vendor` VALUES (1, '【机美】饮料自动贩卖机001', NULL, NULL, NULL, NULL, 20000.00, 13, '', 1, '/assets/img/customer/vendor/ss1.jpg', '/assets/img/customer/vendor/ss2.jpg', '/assets/img/customer/vendor/ss1.jpg', '/assets/img/customer/vendor/ss1.jpg');
INSERT INTO `t_vendor` VALUES (2, '【机美】饮料自动贩卖机002', NULL, NULL, NULL, NULL, 2500.00, 1, NULL, 1, '/assets/img/customer/vendor/ss2.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (3, '【机美】饮料自动贩卖机003', NULL, NULL, NULL, NULL, 26000.00, 12, '', 1, '/assets/img/customer/vendor/ss3.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (4, '【机美】饮料自动贩卖机004', NULL, NULL, NULL, NULL, 12800.00, 15, '', 1, '/assets/img/customer/vendor/ss4.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (5, '【机美】饮料自动贩卖机005', NULL, NULL, NULL, NULL, 26900.00, 2, '', 1, '/assets/img/customer/vendor/ss5.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (6, '【机美】饮料自动贩卖机006', NULL, NULL, NULL, NULL, 154356.00, 15, NULL, 1, '/assets/img/customer/vendor/ss6.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (7, '【机美】饮料自动贩卖机007', NULL, NULL, NULL, NULL, 25000.00, 0, NULL, 1, '/assets/img/customer/vendor/ss7.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (8, '【机美】饮料自动贩卖机008', NULL, NULL, NULL, NULL, 16000.00, 1, NULL, 1, '/assets/img/customer/vendor/ss8.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (9, '【机美】饮料自动贩卖机009', NULL, NULL, NULL, NULL, 16500.00, 15, NULL, 1, '/assets/img/customer/vendor/ss9.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (10, '【机美】饮料自动贩卖机010', NULL, NULL, NULL, NULL, 27000.00, 10, NULL, 1, '/assets/img/customer/vendor/ss10.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (11, '【机美】饮料自动贩卖机011', NULL, NULL, NULL, NULL, 16300.00, 10, NULL, 1, '/assets/img/customer/vendor/ss11.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (12, '【机美】饮料自动贩卖机012', NULL, NULL, NULL, NULL, 15000.00, 5, NULL, 1, '/assets/img/customer/vendor/ss12.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (13, '【机美】酸奶自动贩卖机001', NULL, NULL, NULL, NULL, 16000.00, 1, NULL, 2, '/assets/img/customer/vendor/sn1.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (14, '【机美】酸奶自动贩卖机002', NULL, NULL, NULL, NULL, 15000.00, 5, NULL, 2, '/assets/img/customer/vendor/sn2.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (15, '【机美】酸奶自动贩卖机003', NULL, NULL, NULL, NULL, 17800.00, 20, NULL, 2, '/assets/img/customer/vendor/sn3.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (16, '【机美】酸奶自动贩卖机004', NULL, NULL, NULL, NULL, 21600.00, 1, NULL, 2, '/assets/img/customer/vendor/sn4.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (17, '【机美】酸奶自动贩卖机005', NULL, NULL, NULL, NULL, 24603.00, 1, NULL, 2, '/assets/img/customer/vendor/sn5.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (18, '【机美】酸奶自动贩卖机006', NULL, NULL, NULL, NULL, 12364.00, 2, NULL, 2, '/assets/img/customer/vendor/sn6.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (19, '【机美】盒饭自动贩卖机001', NULL, NULL, NULL, NULL, 15600.00, 1, NULL, 3, '/assets/img/customer/vendor/sf1.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (20, '【机美】盒饭自动贩卖机002', NULL, NULL, NULL, NULL, 16700.00, 1, NULL, 3, '/assets/img/customer/vendor/sf2.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (21, '【机美】盒饭自动贩卖机003', NULL, NULL, NULL, NULL, 17600.00, 1, NULL, 3, '/assets/img/customer/vendor/sf3.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (22, '【机美】冰淇淋自动贩卖机001', NULL, NULL, NULL, NULL, 26000.00, 2, NULL, 4, '/assets/img/customer/vendor/sb1.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (23, '【机美】冰淇淋自动贩卖机002', NULL, NULL, NULL, NULL, 25000.00, 2, NULL, 4, '/assets/img/customer/vendor/sb2.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (24, '【机美】冰淇淋自动贩卖机003', NULL, NULL, NULL, NULL, 21000.00, 3, '', 4, '/assets/img/customer/vendor/sb3.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (25, '【机美】综合自动贩卖机001', NULL, NULL, NULL, NULL, 15600.00, 1, NULL, 5, '/assets/img/customer/vendor/zh1.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (26, '【机美】综合自动贩卖机002', NULL, NULL, NULL, NULL, 19600.00, 10, '', 5, '/assets/img/customer/vendor/zh2.jpg', NULL, NULL, NULL);
INSERT INTO `t_vendor` VALUES (27, '【机美】综合自动贩卖机003', NULL, NULL, NULL, NULL, 12360.00, 5, '', 5, '/assets/img/customer/vendor/zh3.jpg', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_vendor_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_vendor_goods`;
CREATE TABLE `t_vendor_goods`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `symbol_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goods_id` int(10) NULL DEFAULT NULL,
  `goods_count` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `vendor_id`(`symbol_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 426 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_vendor_goods
-- ----------------------------
INSERT INTO `t_vendor_goods` VALUES (16, '1', 1, 13);
INSERT INTO `t_vendor_goods` VALUES (17, '1', 2, 37);
INSERT INTO `t_vendor_goods` VALUES (18, '1', 3, 22);
INSERT INTO `t_vendor_goods` VALUES (19, '1', 4, 33);
INSERT INTO `t_vendor_goods` VALUES (20, '1', 5, 35);
INSERT INTO `t_vendor_goods` VALUES (21, '1', 6, 16);
INSERT INTO `t_vendor_goods` VALUES (22, '1', 7, 21);
INSERT INTO `t_vendor_goods` VALUES (23, '1', 8, 33);
INSERT INTO `t_vendor_goods` VALUES (24, '1', 9, 22);
INSERT INTO `t_vendor_goods` VALUES (25, '1', 10, 21);
INSERT INTO `t_vendor_goods` VALUES (26, '1', 11, 21);
INSERT INTO `t_vendor_goods` VALUES (27, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (28, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (29, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (30, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (31, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (32, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (33, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (34, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (35, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (36, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (37, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (38, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (39, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (40, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (41, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (42, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (43, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (44, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (45, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (46, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (47, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (48, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (49, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (50, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (51, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (52, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (53, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (54, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (55, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (56, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (57, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (58, '3d034f5b-0c3d-4246-b94c-342b451f4acd', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (59, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (60, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (61, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (62, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (63, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (64, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (65, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (66, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (67, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (68, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (69, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (70, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (71, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (72, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (73, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (74, '46a32ba5-669d-471f-a9b9-7f5f3cc1736f', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (75, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (76, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (77, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (78, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (79, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (80, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (81, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (82, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (83, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (84, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (85, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (86, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (87, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (88, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (89, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (90, 'eb691ea7-0c66-4a04-8e6b-09b883bdbf1b', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (91, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (92, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (93, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (94, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (95, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (96, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (97, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (98, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (99, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (100, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (101, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (102, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (103, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (104, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (105, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (106, '81d08e45-69d1-41ec-93c9-fec3ad48825c', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (107, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (108, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (109, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (110, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (111, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (112, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (113, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (114, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (115, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (116, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (117, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (118, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (119, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (120, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (121, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (122, 'b5eb23df-6052-4824-8ef8-5c934723b8dd', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (123, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (124, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (125, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (126, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (127, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (128, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (129, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (130, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (131, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (132, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (133, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (134, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (135, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (136, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (137, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (138, '9f48ee43-a13d-4e1b-b268-64c2d0fc2c1b', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (139, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (140, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (141, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (142, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (143, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (144, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (145, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (146, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (147, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (148, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (149, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (150, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (151, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (152, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (153, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (154, '11541edf-4e6e-4efb-93a3-ceaed261c89e', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (155, '2dbd4c34-3d81-490f-ac62-a1633826f920', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (156, '2dbd4c34-3d81-490f-ac62-a1633826f920', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (157, '2dbd4c34-3d81-490f-ac62-a1633826f920', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (158, '2dbd4c34-3d81-490f-ac62-a1633826f920', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (159, '2dbd4c34-3d81-490f-ac62-a1633826f920', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (160, '2dbd4c34-3d81-490f-ac62-a1633826f920', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (161, '2dbd4c34-3d81-490f-ac62-a1633826f920', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (162, '2dbd4c34-3d81-490f-ac62-a1633826f920', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (163, '2dbd4c34-3d81-490f-ac62-a1633826f920', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (164, '2dbd4c34-3d81-490f-ac62-a1633826f920', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (165, '2dbd4c34-3d81-490f-ac62-a1633826f920', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (166, '2dbd4c34-3d81-490f-ac62-a1633826f920', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (167, '2dbd4c34-3d81-490f-ac62-a1633826f920', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (168, '2dbd4c34-3d81-490f-ac62-a1633826f920', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (169, '2dbd4c34-3d81-490f-ac62-a1633826f920', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (170, '2dbd4c34-3d81-490f-ac62-a1633826f920', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (171, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (172, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (173, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (174, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (175, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (176, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (177, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (178, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (179, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (180, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (181, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (182, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (183, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (184, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (185, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (186, '1e461d9a-bb5f-457b-81da-e4d4dfa27d49', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (187, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (188, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (189, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (190, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (191, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (192, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 6, 15);
INSERT INTO `t_vendor_goods` VALUES (193, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (194, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (195, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (196, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (197, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (198, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (199, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (200, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (201, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (202, 'dd99fca7-e0be-48ba-bc11-cd1d2edf3c2f', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (203, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (204, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (205, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (206, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (207, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (208, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (209, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (210, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (211, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (212, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (213, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (214, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (215, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (216, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (217, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (218, '8a27629a-7fb3-4f80-a8f4-7ed1bea3ef9d', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (219, '33596f49-92b8-4424-9c65-702c59cdcf1a', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (220, '33596f49-92b8-4424-9c65-702c59cdcf1a', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (221, '33596f49-92b8-4424-9c65-702c59cdcf1a', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (222, '33596f49-92b8-4424-9c65-702c59cdcf1a', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (223, '33596f49-92b8-4424-9c65-702c59cdcf1a', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (224, '33596f49-92b8-4424-9c65-702c59cdcf1a', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (225, '33596f49-92b8-4424-9c65-702c59cdcf1a', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (226, '33596f49-92b8-4424-9c65-702c59cdcf1a', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (227, '33596f49-92b8-4424-9c65-702c59cdcf1a', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (228, '33596f49-92b8-4424-9c65-702c59cdcf1a', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (229, '33596f49-92b8-4424-9c65-702c59cdcf1a', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (230, '33596f49-92b8-4424-9c65-702c59cdcf1a', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (231, '33596f49-92b8-4424-9c65-702c59cdcf1a', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (232, '33596f49-92b8-4424-9c65-702c59cdcf1a', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (233, '33596f49-92b8-4424-9c65-702c59cdcf1a', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (234, '33596f49-92b8-4424-9c65-702c59cdcf1a', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (235, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (236, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (237, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (238, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (239, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (240, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (241, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 7, 15);
INSERT INTO `t_vendor_goods` VALUES (242, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (243, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (244, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (245, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (246, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (247, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (248, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (249, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (250, '46ddefb7-41fd-4c0f-a177-090a3d2ad23c', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (251, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (252, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (253, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (254, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (255, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (256, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (257, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (258, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (259, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (260, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (261, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (262, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (263, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (264, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (265, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (266, 'bdac0dd1-1ace-4e28-9e0a-62c4648e38e4', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (267, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (268, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (269, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (270, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (271, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (272, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (273, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (274, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (275, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (276, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (277, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (278, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (279, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (280, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (281, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (282, 'f22ef06a-8232-4cda-b34c-7773f91da0ed', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (283, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (284, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (285, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (286, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (287, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (288, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (289, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (290, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (291, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (292, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (293, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (294, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (295, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (296, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (297, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (298, '3cebf2ea-6a99-44b6-bd08-4226958628b4', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (299, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (300, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (301, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (302, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (303, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (304, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (305, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (306, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (307, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (308, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (309, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (310, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (311, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (312, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (313, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (314, 'de9cb896-ab1d-4dc8-a0e3-b7bbc453901f', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (315, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (316, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (317, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (318, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (319, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (320, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (321, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (322, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (323, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (324, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (325, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (326, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (327, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (328, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (329, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (330, 'a2cde851-b1b5-42c7-9c45-9c2788e2a389', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (331, '187810a9-2289-4dc3-bed0-40608ef9c96a', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (332, '187810a9-2289-4dc3-bed0-40608ef9c96a', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (333, '187810a9-2289-4dc3-bed0-40608ef9c96a', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (334, '187810a9-2289-4dc3-bed0-40608ef9c96a', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (335, '187810a9-2289-4dc3-bed0-40608ef9c96a', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (336, '187810a9-2289-4dc3-bed0-40608ef9c96a', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (337, '187810a9-2289-4dc3-bed0-40608ef9c96a', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (338, '187810a9-2289-4dc3-bed0-40608ef9c96a', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (339, '187810a9-2289-4dc3-bed0-40608ef9c96a', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (340, '187810a9-2289-4dc3-bed0-40608ef9c96a', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (341, '187810a9-2289-4dc3-bed0-40608ef9c96a', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (342, '187810a9-2289-4dc3-bed0-40608ef9c96a', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (343, '187810a9-2289-4dc3-bed0-40608ef9c96a', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (344, '187810a9-2289-4dc3-bed0-40608ef9c96a', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (345, '187810a9-2289-4dc3-bed0-40608ef9c96a', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (346, '187810a9-2289-4dc3-bed0-40608ef9c96a', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (347, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (348, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (349, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (350, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (351, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (352, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (353, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (354, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (355, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (356, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (357, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (358, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (359, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (360, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (361, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (362, '6b71f3f8-8edb-426d-8452-f3d185afa8e3', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (363, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (364, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (365, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (366, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (367, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (368, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (369, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (370, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (371, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (372, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (373, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (374, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (375, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (376, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (377, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (378, 'c53bf2a6-8ae1-4b9a-b8f0-42764bd1c083', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (379, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (380, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (381, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (382, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (383, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (384, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (385, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (386, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (387, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (388, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (389, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (390, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (391, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (392, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (393, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (394, '864e2469-f98b-4f4d-9688-fc2ea98fc8f2', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (395, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 1, 20);
INSERT INTO `t_vendor_goods` VALUES (396, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (397, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (398, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (399, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (400, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (401, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 7, 20);
INSERT INTO `t_vendor_goods` VALUES (402, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (403, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (404, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (405, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (406, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (407, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (408, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (409, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (410, 'ce06ce63-e77f-471b-b512-cb64eace4da3', 16, 20);
INSERT INTO `t_vendor_goods` VALUES (411, '74451046-125d-425b-b4cc-d9e26234b36f', 1, 35);
INSERT INTO `t_vendor_goods` VALUES (412, '74451046-125d-425b-b4cc-d9e26234b36f', 2, 20);
INSERT INTO `t_vendor_goods` VALUES (413, '74451046-125d-425b-b4cc-d9e26234b36f', 3, 20);
INSERT INTO `t_vendor_goods` VALUES (414, '74451046-125d-425b-b4cc-d9e26234b36f', 4, 20);
INSERT INTO `t_vendor_goods` VALUES (415, '74451046-125d-425b-b4cc-d9e26234b36f', 5, 20);
INSERT INTO `t_vendor_goods` VALUES (416, '74451046-125d-425b-b4cc-d9e26234b36f', 6, 20);
INSERT INTO `t_vendor_goods` VALUES (417, '74451046-125d-425b-b4cc-d9e26234b36f', 7, 54);
INSERT INTO `t_vendor_goods` VALUES (418, '74451046-125d-425b-b4cc-d9e26234b36f', 8, 20);
INSERT INTO `t_vendor_goods` VALUES (419, '74451046-125d-425b-b4cc-d9e26234b36f', 9, 20);
INSERT INTO `t_vendor_goods` VALUES (420, '74451046-125d-425b-b4cc-d9e26234b36f', 10, 20);
INSERT INTO `t_vendor_goods` VALUES (421, '74451046-125d-425b-b4cc-d9e26234b36f', 11, 20);
INSERT INTO `t_vendor_goods` VALUES (422, '74451046-125d-425b-b4cc-d9e26234b36f', 12, 20);
INSERT INTO `t_vendor_goods` VALUES (423, '74451046-125d-425b-b4cc-d9e26234b36f', 13, 20);
INSERT INTO `t_vendor_goods` VALUES (424, '74451046-125d-425b-b4cc-d9e26234b36f', 14, 20);
INSERT INTO `t_vendor_goods` VALUES (425, '74451046-125d-425b-b4cc-d9e26234b36f', 15, 20);
INSERT INTO `t_vendor_goods` VALUES (426, '74451046-125d-425b-b4cc-d9e26234b36f', 16, 20);

-- ----------------------------
-- Table structure for t_vendortype
-- ----------------------------
DROP TABLE IF EXISTS `t_vendortype`;
CREATE TABLE `t_vendortype`  (
  `type_id` int(10) NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_vendortype
-- ----------------------------
INSERT INTO `t_vendortype` VALUES (1, '饮料机');
INSERT INTO `t_vendortype` VALUES (2, '酸奶机');
INSERT INTO `t_vendortype` VALUES (3, '盒饭机');
INSERT INTO `t_vendortype` VALUES (4, '冰淇淋机');
INSERT INTO `t_vendortype` VALUES (5, '综合机');

-- ----------------------------
-- Procedure structure for insert_t_install_infor_log
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_t_install_infor_log`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_t_install_infor_log`(IN install_id int)
BEGIN
declare vendor_id int DEFAULT 0;
declare user_id int DEFAULT 0;
declare install_time varchar(255);
SELECT *  from t_install_infor
where install_id = install_id;
set vendor_id = vendor_id;
set user_id = user_id;
set install_time = install_time;
insert into t_install_infor_log(install_id,user_id,vendor_id,install_time) 
values(install_id,user_id,vendor_id,install_time);
delete from t_install_infor
where install_id = install_id;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_t_task
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_t_task`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_t_task`(IN vendor_id int,useid int)
BEGIN
declare userid int DEFAULT 0;
declare username varchar(255);
declare userphone varchar(255);
SELECT userid into userid FROM t_user
where type = 5
ORDER BY RAND() LIMIT 1 ;
select realname into username from t_user
where userid = useid;
select consignee_phone into userphone from t_consignee
where userid = useid;
insert into tasks(vendor_id,realname,consignee_phone) 
values(vendor_id,username,userphone);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_t_task_log
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_t_task_log`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_t_task_log`(IN taskid int,fix_date varchar(255))
BEGIN
declare vendor_id int DEFAULT 0;
declare username varchar(255);
declare userphone varchar(255);
SELECT *  from t_task
where taskid = taskid;
set vendor_id = vendor_id;
set username = realname;
set userphone = consignee_phone;
insert into tasks(vendor_id,realname,consignee_phone,fix_date) 
values(vendor_id,username,userphone,fix_date);
delete from t_task
where taskid = taskid;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
