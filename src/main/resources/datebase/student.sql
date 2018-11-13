CREATE TABLE `student` (
  `id` bigint(20) NOT NULL COMMENT '学生ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_update_worker` varchar(20) DEFAULT NULL COMMENT '修改人',
  `insert_time` datetime DEFAULT NULL COMMENT '添加时间',
  `insert_worker` varchar(20) DEFAULT NULL COMMENT '添加人',
  `del_status` tinyint(1) DEFAULT '0' COMMENT '状态0.未删除 1.已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;