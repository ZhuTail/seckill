-- 数据库初始化脚本

-- 创建秒杀库存表
CREATE TABLE seckill(
  seckill_id bigint AUTO_INCREMENT NOT NULL COMMENT '秒杀商品ID',
  name varchar(100) NOT NULL COMMENT '商品名称',
  number int NOT NULL COMMENT '商品数量',
  start_time TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  end_time TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';


-- 初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
VALUES
 ('1元秒杀iPhone7','100','2017-04-05 00:00:00','2017-04-06 00:00:00'),
 ('1元秒杀iPhone6s','100','2017-04-05 00:00:00','2017-04-06 00:00:00'),
 ('1元秒杀iPhone6','100','2017-04-05 00:00:00','2017-04-06 00:00:00'),
 ('1元秒杀iPad','100','2017-04-05 00:00:00','2017-04-06 00:00:00');
insert into seckill_detail(seckill_id,user_phone) values(1000,15665412278) 
-- 创建秒杀明细表
CREATE TABLE seckill_detail(
  seckill_id bigint not null COMMENT '秒杀商品ID',
  user_phone bigint not null COMMENT '秒杀手机号',
  status tinyint DEFAULT -1 not null COMMENT '秒杀状态：-1 无效,0 有效',
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP null COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  key idx_create_time(create_time)
) ENGINE = INNODB DEFAULT CHARSET=utf8 COMMENT '秒杀明细表';