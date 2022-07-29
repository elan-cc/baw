package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * @author ruoyi
 * @date 2022年03月12日10:31
 */
public class BawBaseCarConfigParamDeserialization {
    /**
     * 车型配置编码
     */
    @Excel(name = "车型配置编码")
    private String carConfigCode;
    /**
     * 车系编号
     */
    @Excel(name = "车系编号")
    private String carSeriesCode;
    /**
     * 车辆型号
     */
    @Excel(name = "车辆型号")
    private String car_model;
    /**
     * 车辆名称
     */
    @Excel(name = "车辆名称")
    private String car_name;
    /**
     * 厂商指导价
     */
    @Excel(name = "厂商指导价")
    private String manufacturer_price;
    /**
     * 补贴后售价
     */
    @Excel(name = "补贴后售价")
    private String price_after;
    /**
     * 厂商
     */
    @Excel(name = "厂商")
    private String car_manufacturer;
    /**
     * 级别
     */
    @Excel(name = "级别")
    private String level;
    /**
     * 上市时间
     */
    @Excel(name = "上市时间")
    private String time_market;
    /**
     * 发动机
     */
    @Excel(name = "发动机")
    private String engine;
    /**
     * 变速箱
     */
    @Excel(name = "变速箱")
    private String transmission_case;
    /**
     * 最高车速(km-h)
     */
    @Excel(name = "最高车速(km-h)")
    private String maximum_speed;
    /**
     * 官方0-100km-h加速(s)
     */
    @Excel(name = "官方0-100km-h加速(s)")
    private String official_acceleration;
    /**
     * 黄标纸油耗(L-100km)
     */
    @Excel(name = "黄标纸油耗(L-100km)")
    private String yellow_label;
    /**
     * 整车质保
     */
    @Excel(name = "整车质保")
    private String vehicle_warranty;
    /**
     * 额定载质量(kg)
     */
    @Excel(name = "额定载质量(kg)")
    private String load_mass;
    /**
     * 总质量(kg)
     */
    @Excel(name = "总质量(kg)")
    private String total_mass;
    /**
     * 邮箱容积(L)
     */
    @Excel(name = "邮箱容积(L)")
    private String mailbox_volume;
    /**
     * 综合油耗(L/100km)
     */
    @Excel(name = "综合油耗(L/100km)")
    private String fuel_consumption;
    /**
     * 款型名称
     */
    @Excel(name = "款型名称")
    private String style_name;
    /**
     * 车身颜色
     */
    @Excel(name = "车身颜色")
    private String car_color;
    /**
     * 对应整车公告
     */
    @Excel(name = "对应整车公告")
    private String vehicle_announcement;
    /**
     * 对应底盘公告
     */
    @Excel(name = "对应底盘公告")
    private String chassis_announcement;
    /**
     * 配置代号
     */
    @Excel(name = "配置代号")
    private String configuration_code;
    /**
     * 排放标准
     */
    @Excel(name = "排放标准")
    private String emission_standard;
    /**
     * 长*宽*高(mm)
     */
    @Excel(name = "长*宽*高（mm）")
    private String car_long_width_height;
    /**
     * 长度(mm)
     */
    @Excel(name = "长度(mm)")
    private String car_long;
    /**
     * 宽度(mm)
     */
    @Excel(name = "宽度(mm)")
    private String car_width;
    /**
     * 高度(mm)
     */
    @Excel(name = "高度(mm)")
    private String car_height;
    /**
     * 货厢长度(mm)
     */
    @Excel(name = "货厢长度(mm)")
    private String compartment_length;
    /**
     * 货厢宽度(mm)
     */
    @Excel(name = "货厢宽度(mm)")
    private String compartment_width;
    /**
     * 货厢高度(mm)
     */
    @Excel(name = "高度(mm)")
    private String compartment_heigh;
    /**
     * 轴距(mm)
     */
    @Excel(name = "轴距(mm)")
    private String car_wheelbase;
    /**
     * 前轮距(mm)
     */
    @Excel(name = "前轮距(mm)")
    private String front_track;
    /**
     * 后轮距(mm)
     */
    @Excel(name = "后轮距(mm)")
    private String rear_track;
    /**
     * 最小离地间隙(mm)
     */
    @Excel(name = "最小离地间隙(mm)")
    private String minimum_ground;
    /**
     * 整备质量(kg)
     */
    @Excel(name = "整备质量(kg)")
    private String curb_weight;
    /**
     * 车身形式
     */
    @Excel(name = "车身形式")
    private String body_structure;
    /**
     * 车门数(个)
     */
    @Excel(name = "车门数(个)")
    private String number_doors;
    /**
     * 座位数(个)
     */
    @Excel(name = "座位数(个)")
    private String number_seats;
    /**
     * 油箱容积(L)
     */
    @Excel(name = "油箱容积(L)")
    private String tank_volume;
    /**
     * 行李厢容积(L)
     */
    @Excel(name = "行李厢容积(L)")
    private String luggage_volume;
    /**
     * 货箱尺寸（皮卡必填）
     */
    @Excel(name = "货箱尺寸（皮卡必填）")
    private String container_size;
    /**
     * 最大载重质量（皮卡、微卡）
     */
    @Excel(name = "最大载重质量（皮卡、微卡）")
    private String maximum_mass;
    /**
     * 接近角(°)
     */
    @Excel(name = "接近角(°)")
    private String approach_angle;
    /**
     * 离去角(°)
     */
    @Excel(name = "离去角(°)")
    private String departure_angle;
    /**
     * 纵向通过角
     */
    @Excel(name = "纵向通过角")
    private String longitudinal_angle;
    /**
     * 最大爬坡角度
     */
    @Excel(name = "最大爬坡角度")
    private String maximum_angle;
    /**
     * 最小转弯半径
     */
    @Excel(name = "最小转弯半径")
    private String maximum_radius;
    /**
     * 最大涉水深度
     */
    @Excel(name = "最大涉水深度")
    private String maximum_depth;
    /**
     * 发动机位置
     */
    @Excel(name = "发动机位置")
    private String engine_position;
    /**
     * 发动机型式
     */
    @Excel(name = "发动机型式")
    private String engine_type;
    /**
     * 额定功率
     */
    @Excel(name = "额定功率")
    private String rated_power;
    /**
     * 发动机型号
     */
    @Excel(name = "发动机型号")
    private String engine_model;
    /**
     * 排量(mL)
     */
    @Excel(name = "排量(mL)")
    private String displacement;
    /**
     * 进气形式
     */
    @Excel(name = "进气形式")
    private String intake_form;
    /**
     * 气缸排列形式
     */
    @Excel(name = "气缸排列形式")
    private String cylinder_arrangement;
    /**
     * 气缸数(个)
     */
    @Excel(name = "气缸数(个)")
    private String number_cylinders;
    /**
     * 每缸气门数(个)
     */
    @Excel(name = "每缸气门数(个)")
    private String valve_trains;
    /**
     * 压缩比
     */
    @Excel(name = "压缩比")
    private String compression_ratio;
    /**
     * 配气机构
     */
    @Excel(name = "配气机构")
    private String valve_train;
    /**
     * 缸径(mm)
     */
    @Excel(name = "缸径(mm)")
    private String cylinder_bore;
    /**
     * 行程(mm)
     */
    @Excel(name = "行程(mm)")
    private String trip;
    /**
     * 最大马力(Ps)
     */
    @Excel(name = "最大马力(Ps)")
    private String maximum_horsepower;
    /**
     * 最大功率(kW)
     */
    @Excel(name = "最大功率(kW)")
    private String maximum_power;
    /**
     * 最大功率转速(rpm)
     */
    @Excel(name = "最大功率转速(rpm)")
    private String engine_speed;
    /**
     * 发动机最大扭矩（N·m）
     */
    @Excel(name = "发动机最大扭矩（N·m）")
    private String maximum_torque;
    /**
     * 最大扭矩转速(r/min)
     */
    @Excel(name = "最大扭矩转速(r/min)")
    private String engine_torque;
    /**
     * 燃料形式
     */
    @Excel(name = "燃料形式")
    private String fuel_form;
    /**
     * 燃油标号
     */
    @Excel(name = "燃油标号")
    private String fuel_label;
    /**
     * 供油方式
     */
    @Excel(name = "供油方式")
    private String supply_mode;
    /**
     * 缸盖材料
     */
    @Excel(name = "缸盖材料")
    private String head_material;
    /**
     * 缸体材料
     */
    @Excel(name = "缸体材料")
    private String block_material;
    /**
     * 环保标准
     */
    @Excel(name = "环保标准")
    private String environmental_standards;
    /**
     * 电机类型
     */
    @Excel(name = "电机类型")
    private String motor_type;
    /**
     * 电动机总功率
     */
    @Excel(name = "电动机总功率")
    private String motor_power;
    /**
     * 电动机总扭矩
     */
    @Excel(name = "电动机总扭矩")
    private String total_torque;
    /**
     * 前电动机最大功率
     */
    @Excel(name = "前电动机最大功率")
    private String power_motor;
    /**
     * 前电动机最大扭矩
     */
    @Excel(name = "前电动机最大扭矩")
    private String torque_motor;
    /**
     * 后电动机最大功率
     */
    @Excel(name = "后电动机最大功率")
    private String power_front;
    /**
     * 后电动机最大扭矩
     */
    @Excel(name = "后电动机最大扭矩")
    private String rear_motor;
    /**
     * 系统综合功率
     */
    @Excel(name = "系统综合功率")
    private String comprehensive_power;
    /**
     * 系统综合扭矩
     */
    @Excel(name = "系统综合扭矩")
    private String comprehensive_torque;
    /**
     * 驱动电机数
     */
    @Excel(name = "驱动电机数")
    private String drive_motors;
    /**
     * 电机布局
     */
    @Excel(name = "电机布局")
    private String motor_layout;
    /**
     * 电池类型
     */
    @Excel(name = "电池类型")
    private String battery_type;
    /**
     * 工信部续航里程
     */
    @Excel(name = "工信部续航里程")
    private String mileage_miit;
    /**
     * 电池容量
     */
    @Excel(name = "电池容量")
    private String battery_capacity;
    /**
     * 百公里耗电量
     */
    @Excel(name = "百公里耗电量")
    private String power_consumption;
    /**
     * 电池组质保
     */
    @Excel(name = "电池组质保")
    private String battery_pack;
    /**
     * 充电时间（单位小时）
     */
    @Excel(name = "充电时间（单位小时）")
    private String charging_time;
    /**
     * 快充电量百分比
     */
    @Excel(name = "快充电量百分比")
    private String fast_charge;
    /**
     * 电池加热功能
     */
    @Excel(name = "电池加热功能")
    private String battery_heating;
    /**
     * 变速器类型
     */
    @Excel(name = "变速器类型")
    private String transmission_form;
    /**
     * 变速器
     */
    @Excel(name = "变速器")
    private String transmissions;
    /**
     * 简称
     */
    @Excel(name = "简称")
    private String abbreviation;
    /**
     * 挡位个数
     */
    @Excel(name = "挡位个数")
    private String number_gears;
    /**
     * 变速箱类型
     */
    @Excel(name = "变速箱类型")
    private String transmission_type;
    /**
     * 换挡形式
     */
    @Excel(name = "换挡形式")
    private String shift_form;
    /**
     * 变速箱品牌
     */
    @Excel(name = "变速箱品牌")
    private String gearbox_brand;
    /**
     * 电动转向
     */
    @Excel(name = "电动转向")
    private String electric_steering;
    /**
     * 驱动类型
     */
    @Excel(name = "驱动类型")
    private String driving_mode;
    /**
     * 四驱形式
     */
    @Excel(name = "四驱形式")
    private String wd_form;
    /**
     * 前悬架系统
     */
    @Excel(name = "前悬架系统")
    private String front_type;
    /**
     * 后悬架系统
     */
    @Excel(name = "后悬架系统")
    private String rear_type;
    /**
     * 助力类型
     */
    @Excel(name = "助力类型")
    private String type_assistance;
    /**
     * 车体结构
     */
    @Excel(name = "车体结构")
    private String car_structure;
    /**
     * 制动系统方式
     */
    @Excel(name = "制动系统方式")
    private String braking_mode;
    /**
     * 钢板弹簧片数
     */
    @Excel(name = "钢板弹簧片数")
    private String number_springs;
    /**
     * 前制动器类型
     */
    @Excel(name = "前制动器类型")
    private String brake_type;
    /**
     * 后制动器类型
     */
    @Excel(name = "后制动器类型")
    private String rear_brake;
    /**
     * 驻车制动类型
     */
    @Excel(name = "驻车制动类型")
    private String parking_type;
    /**
     * 前轮胎规格
     */
    @Excel(name = "前轮胎规格")
    private String front_specification;
    /**
     * 后轮胎规格
     */
    @Excel(name = "后轮胎规格")
    private String rear_specification;
    /**
     * 轮胎品牌
     */
    @Excel(name = "轮胎品牌")
    private String tire_brand;
    /**
     * 备胎规格
     */
    @Excel(name = "备胎规格")
    private String spare_specification;
    /**
     * 以下配置根据实际情况填写，如有必填{有：●；选装○}不填当未配备处理
     */
    @Excel(name = "以下配置根据实际情况填写，如有必填{有：●；选装○}不填当未配备处理")
    private String not_equipped;
    /**
     * 驾驶座安全气囊
     */
    @Excel(name = "驾驶座安全气囊")
    private String driver_airbag;
    /**
     * 副驾驶安全气囊
     */
    @Excel(name = "副驾驶安全气囊")
    private String passenger_airbag;
    /**
     * ABS+EBD
     */
    @Excel(name = "ABS+EBD")
    private String abs_ebd;
    /**
     * 前排侧气囊
     */
    @Excel(name = "前排侧气囊")
    private String front_airbag;
    /**
     * 后排侧气囊
     */
    @Excel(name = "后排侧气囊")
    private String rear_airbag;
    /**
     * 前-后排头部气囊(气帘)
     */
    @Excel(name = "前-后排头部气囊(气帘)")
    private String head_airbag;
    /**
     * 膝部气囊
     */
    @Excel(name = "膝部气囊")
    private String knee_airbag;
    /**
     * 后排安全带气囊
     */
    @Excel(name = "后排安全带气囊")
    private String belt_airbag;
    /**
     * 后排中央气囊
     */
    @Excel(name = "后排中央气囊")
    private String center_airbag;
    /**
     * 被动行人保护装置
     */
    @Excel(name = "被动行人保护装置")
    private String protection_device;
    /**
     * 胎压异常报警
     */
    @Excel(name = "胎压异常报警")
    private String pressure_alarm;
    /**
     * 胎压显示功能
     */
    @Excel(name = "胎压显示功能")
    private String display_function;
    /**
     * 零胎压继续行驶-防爆胎
     */
    @Excel(name = "零胎压继续行驶-防爆胎")
    private String proof_tyre;
    /**
     * 安全带未系提示
     */
    @Excel(name = "安全带未系提示")
    private String fastened_prompt;
    /**
     * ISOFIX儿童座椅接口
     */
    @Excel(name = "ISOFIX儿童座椅接口")
    private String child_seat;
    /**
     * ABS防抱死
     */
    @Excel(name = "ABS防抱死")
    private String anti_lock;
    /**
     * 制动力分配(EBD-CBC等)
     */
    @Excel(name = "制动力分配(EBD-CBC等)")
    private String force_distribution;
    /**
     * 刹车辅助(EBA-BAS-BA等)
     */
    @Excel(name = "刹车辅助(EBA-BAS-BA等)")
    private String brake_assist;
    /**
     * 牵引力控制(ASR-TCS-TRC等)
     */
    @Excel(name = "牵引力控制(ASR-TCS-TRC等)")
    private String traction_control;
    /**
     * 车身稳定控制(ESC-ESP-DSC等)
     */
    @Excel(name = "车身稳定控制(ESC-ESP-DSC等)")
    private String stability_control;
    /**
     * 并线辅助
     */
    @Excel(name = "并线辅助")
    private String parallel_auxiliary;
    /**
     * 车道偏离预警系统
     */
    @Excel(name = "车道偏离预警系统")
    private String warning_system;
    /**
     * 车道保持辅助系统
     */
    @Excel(name = "车道保持辅助系统")
    private String assist_system;
    /**
     * 主动刹车-主动安全系统
     */
    @Excel(name = "主动刹车-主动安全系统")
    private String active_braking;
    /**
     * 夜视系统
     */
    @Excel(name = "夜视系统")
    private String vision_system;
    /**
     * 疲劳驾驶提示
     */
    @Excel(name = "疲劳驾驶提示")
    private String fatigue_tips;
    /**
     * 道路交通标识识别
     */
    @Excel(name = "道路交通标识识别")
    private String traffic_recognition;
    /**
     * 涉水感应系统
     */
    @Excel(name = "涉水感应系统")
    private String wade_system;
    /**
     * 前雷达
     */
    @Excel(name = "前雷达")
    private String front_radar;
    /**
     * 后倒车雷达
     */
    @Excel(name = "后倒车雷达")
    private String rear_radar;
    /**
     * 驾驶辅助影像
     */
    @Excel(name = "驾驶辅助影像")
    private String assistance_image;
    /**
     * 定速巡航
     */
    @Excel(name = "定速巡航")
    private String cruise_control;
    /**
     * 自适应巡航
     */
    @Excel(name = "自适应巡航")
    private String adaptive_cruise;
    /**
     * 全速自适应巡航（支持停走功能）
     */
    @Excel(name = "全速自适应巡航（支持停走功能）")
    private String speed_cruise;
    /**
     * 自动泊车入位
     */
    @Excel(name = "自动泊车入位")
    private String automatic_park;
    /**
     * 发动机启停技术
     */
    @Excel(name = "发动机启停技术")
    private String stop_technology;
    /**
     * 自动驾驶技术
     */
    @Excel(name = "自动驾驶技术")
    private String automatic_driving;
    /**
     * 自动驻车
     */
    @Excel(name = "自动驻车")
    private String automatic_parking;
    /**
     * 上坡辅助
     */
    @Excel(name = "上坡辅助")
    private String uphill_assist;
    /**
     * 陡坡缓降
     */
    @Excel(name = "陡坡缓降")
    private String steep_descent;
    /**
     * 悬架软硬调节
     */
    @Excel(name = "悬架软硬调节")
    private String suspension_adjustment;
    /**
     * 悬架高低调节
     */
    @Excel(name = "悬架高低调节")
    private String height_adjustment;
    /**
     * 空气悬架
     */
    @Excel(name = "空气悬架")
    private String air_suspension;
    /**
     * 电磁感应悬架
     */
    @Excel(name = "电磁感应悬架")
    private String electromagnetic_suspension;
    /**
     * 可变转向比
     */
    @Excel(name = "可变转向比")
    private String steering_ratio;
    /**
     * 后轮随动转向
     */
    @Excel(name = "后轮随动转向")
    private String rear_wheel;
    /**
     * 驾驶模式切换
     */
    @Excel(name = "驾驶模式切换")
    private String driving_switching;
    /**
     * 前桥限滑差速器-差速锁
     */
    @Excel(name = "前桥限滑差速器-差速锁")
    private String differential_lock;
    /**
     * 中央差速器锁止功能
     */
    @Excel(name = "中央差速器锁止功能")
    private String locking_function;
    /**
     * 后桥限滑差速器-差速锁
     */
    @Excel(name = "后桥限滑差速器-差速锁")
    private String slip_differential;
    /**
     * 电动天窗
     */
    @Excel(name = "电动天窗")
    private String power_sunroof;
    /**
     * 可开启全景天窗
     */
    @Excel(name = "可开启全景天窗")
    private String openable_panoramic;
    /**
     * 侧杠
     */
    @Excel(name = "侧杠")
    private String side_bar;
    /**
     * 固定式全景天窗
     */
    @Excel(name = "固定式全景天窗")
    private String fixed_roof;
    /**
     * 分段式全景天窗
     */
    @Excel(name = "分段式全景天窗")
    private String segmented_skylight;
    /**
     * 运动外观套件
     */
    @Excel(name = "运动外观套件")
    private String sporty_kit;
    /**
     * 铝合金轮圈
     */
    @Excel(name = "铝合金轮圈")
    private String alloy_wheels;
    /**
     * 电动吸合门
     */
    @Excel(name = "电动吸合门")
    private String electric_door;
    /**
     * 侧滑门
     */
    @Excel(name = "侧滑门")
    private String side_door;
    /**
     * 电动后备厢
     */
    @Excel(name = "电动后备厢")
    private String electric_compartment;
    /**
     * 感应后备厢
     */
    @Excel(name = "感应后备厢")
    private String inductive_trunk;
    /**
     * 电动后备厢位置记忆
     */
    @Excel(name = "电动后备厢位置记忆")
    private String position_memory;
    /**
     * 车顶行李架
     */
    @Excel(name = "车顶行李架")
    private String luggage_rack;
    /**
     * 车侧踏板
     */
    @Excel(name = "车侧踏板")
    private String side_pedal;
    /**
     * 主动闭合进气格栅
     */
    @Excel(name = "主动闭合进气格栅")
    private String intake_grille;
    /**
     * 发动机电子防盗
     */
    @Excel(name = "发动机电子防盗")
    private String anti_theft;
    /**
     * 车内中控锁
     */
    @Excel(name = "车内中控锁")
    private String central_lock;
    /**
     * 遥控钥匙
     */
    @Excel(name = "遥控钥匙")
    private String remote_key;
    /**
     * 触摸屏钥匙
     */
    @Excel(name = "触摸屏钥匙")
    private String screen_key;
    /**
     * 钥匙手环
     */
    @Excel(name = "钥匙手环")
    private String key_bracelet;
    /**
     * 无钥匙启动系统
     */
    @Excel(name = "无钥匙启动系统")
    private String start_system;
    /**
     * 无钥匙进入系统
     */
    @Excel(name = "无钥匙进入系统")
    private String entry_system;
    /**
     * 遥控泊车
     */
    @Excel(name = "遥控泊车")
    private String piloted_parking;
    /**
     * 发动机远程启动
     */
    @Excel(name = "发动机远程启动")
    private String remote_start;
    /**
     * 真皮方向盘
     */
    @Excel(name = "真皮方向盘")
    private String steering_wheel;
    /**
     * 方向盘角度调节
     */
    @Excel(name = "方向盘角度调节")
    private String wheel_adjustment;
    /**
     * 方向盘电动调节
     */
    @Excel(name = "方向盘电动调节")
    private String electric_adjustment;
    /**
     * 多功能方向盘
     */
    @Excel(name = "多功能方向盘")
    private String multifunction_steering;
    /**
     * 方向盘换挡
     */
    @Excel(name = "方向盘换挡")
    private String wheel_shift;
    /**
     * 方向盘加热
     */
    @Excel(name = "方向盘加热")
    private String wheel_heating;
    /**
     * 方向盘记忆
     */
    @Excel(name = "方向盘记忆")
    private String wheel_memory;
    /**
     * 行车电脑显示屏
     */
    @Excel(name = "行车电脑显示屏")
    private String computer_display;
    /**
     * 全液晶仪表盘
     */
    @Excel(name = "全液晶仪表盘")
    private String instrument_panel;
    /**
     * 液晶仪表尺寸
     */
    @Excel(name = "液晶仪表尺寸")
    private String meter_size;
    /**
     * HUD抬头数字显示
     */
    @Excel(name = "HUD抬头数字显示")
    private String hud_head;
    /**
     * 内置行车记录仪
     */
    @Excel(name = "内置行车记录仪")
    private String dash_cam;
    /**
     * 主动降噪
     */
    @Excel(name = "主动降噪")
    private String noise_reduction;
    /**
     * 手机无线充电
     */
    @Excel(name = "手机无线充电")
    private String mobile_phone;
    /**
     * 座椅材质
     */
    @Excel(name = "座椅材质")
    private String seat_material;
    /**
     * 运动风格座椅
     */
    @Excel(name = "运动风格座椅")
    private String sports_seat;
    /**
     * 座椅高低调节
     */
    @Excel(name = "座椅高低调节")
    private String seat_adjustment;
    /**
     * 腰部支撑调节
     */
    @Excel(name = "腰部支撑调节")
    private String lumbar_adjustment;
    /**
     * 肩部支撑调节
     */
    @Excel(name = "肩部支撑调节")
    private String shoulder_adjustment;
    /**
     * 驾驶座调节向数
     */
    @Excel(name = "驾驶座调节向数")
    private String driver_direction;
    /**
     * 副驾驶座调节向数
     */
    @Excel(name = "副驾驶座调节向数")
    private String passenger_direction;
    /**
     * 主驾驶座电动调节
     */
    @Excel(name = "主驾驶座电动调节")
    private String electric_seat;
    /**
     * 副驾驶座电动调节
     */
    @Excel(name = "副驾驶座电动调节")
    private String front_seat;
    /**
     * 第二排靠背角度调节
     */
    @Excel(name = "第二排靠背角度调节")
    private String angle_adjustment;
    /**
     * 第二排座椅移动
     */
    @Excel(name = "第二排座椅移动")
    private String seat_movement;
    /**
     * 后排座椅电动调节
     */
    @Excel(name = "后排座椅电动调节")
    private String rear_seat;
    /**
     * 副驾驶位后排可调节按钮（老板键）
     */
    @Excel(name = "副驾驶位后排可调节按钮（老板键）")
    private String boss_key;
    /**
     * 电动座椅记忆
     */
    @Excel(name = "电动座椅记忆")
    private String power_memory;
    /**
     * 前-后排座椅加热
     */
    @Excel(name = "前-后排座椅加热")
    private String seat_heating;
    /**
     * 前-后排座椅通风
     */
    @Excel(name = "前-后排座椅通风")
    private String seat_ventilation;
    /**
     * 前-后排座椅按摩
     */
    @Excel(name = "前-后排座椅按摩")
    private String seat_massage;
    /**
     * 第二排独立座椅
     */
    @Excel(name = "第二排独立座椅")
    private String independent_seat;
    /**
     * 第三排座椅个数
     */
    @Excel(name = "第三排座椅个数")
    private String third_row;
    /**
     * 后排座椅放倒方式
     */
    @Excel(name = "后排座椅放倒方式")
    private String fall_mode;
    /**
     * 前中央扶手
     */
    @Excel(name = "前中央扶手")
    private String front_armrest;
    /**
     * 后中央扶手
     */
    @Excel(name = "后中央扶手")
    private String rear_armrest;
    /**
     * 后排杯架
     */
    @Excel(name = "后排杯架")
    private String cup_holder;
    /**
     * 后排扶手多媒体控制
     */
    @Excel(name = "后排扶手多媒体控制")
    private String multimedia_control;
    /**
     * 加热-制冷杯架
     */
    @Excel(name = "加热-制冷杯架")
    private String refrigeration_holder;
    /**
     * 驾驶座手动4向调节
     */
    @Excel(name = "驾驶座手动4向调节")
    private String driving_manual;
    /**
     * 副驾驶手动4向调节
     */
    @Excel(name = "副驾驶手动4向调节")
    private String copilot_manual;
    /**
     * GPS导航系统
     */
    @Excel(name = "GPS导航系统")
    private String navigation_system;
    /**
     * 路况信息即时显示
     */
    @Excel(name = "路况信息即时显示")
    private String traffic_information;
    /**
     * 道路救援呼叫
     */
    @Excel(name = "道路救援呼叫")
    private String rescue_call;
    /**
     * 中控台彩色大屏
     */
    @Excel(name = "中控台彩色大屏")
    private String center_console;
    /**
     * 中控台彩色大屏尺寸
     */
    @Excel(name = "中控台彩色大屏尺寸")
    private String screen_size;
    /**
     * 中控液晶屏分屏显示
     */
    @Excel(name = "中控液晶屏分屏显示")
    private String split_screen;
    /**
     * 蓝牙-车载电话
     */
    @Excel(name = "蓝牙-车载电话")
    private String car_phone;
    /**
     * 语音控制
     */
    @Excel(name = "语音控制")
    private String voice_control;
    /**
     * 手势控制
     */
    @Excel(name = "手势控制")
    private String gesture_control;
    /**
     * 车联网
     */
    @Excel(name = "车联网")
    private String internet_vehicles;
    /**
     * 手机互联-映射
     */
    @Excel(name = "手机互联-映射")
    private String phone_interconnection;
    /**
     * 车载电视
     */
    @Excel(name = "车载电视")
    private String car_tv;
    /**
     * 后排液晶屏
     */
    @Excel(name = "后排液晶屏")
    private String rear_lcd;
    /**
     * 220V-230V电源
     */
    @Excel(name = "220V-230V电源")
    private String power_supply;
    /**
     * 外接音源接口
     */
    @Excel(name = "外接音源接口")
    private String source_interface;
    /**
     * USB接口数量
     */
    @Excel(name = "USB接口数量")
    private String usb_interfaces;
    /**
     * CD、DVD
     */
    @Excel(name = "CD、DVD")
    private String cd_dvd;
    /**
     * 电子时钟
     */
    @Excel(name = "电子时钟")
    private String electronic_clock;
    /**
     * 收音机+USB
     */
    @Excel(name = "收音机+USB")
    private String radio_usb;
    /**
     * 收音机
     */
    @Excel(name = "收音机")
    private String radio;
    /**
     * 扬声器品牌
     */
    @Excel(name = "扬声器品牌")
    private String speaker_brand;
    /**
     * 扬声器（个）
     */
    @Excel(name = "扬声器（个）")
    private String number_speakers;
    /**
     * OTA远程升级
     */
    @Excel(name = "OTA远程升级")
    private String remote_upgrade;
    /**
     * 近光灯
     */
    @Excel(name = "近光灯")
    private String dipped_headlight;
    /**
     * 远光灯
     */
    @Excel(name = "远光灯")
    private String high_beam;
    /**
     * LED日间行车灯
     */
    @Excel(name = "LED日间行车灯")
    private String running_lights;
    /**
     * 自适应远近光
     */
    @Excel(name = "自适应远近光")
    private String adaptive_beam;
    /**
     * 自动头灯
     */
    @Excel(name = "自动头灯")
    private String automatic_headlamp;
    /**
     * 转向辅助灯
     */
    @Excel(name = "转向辅助灯")
    private String assist_lamp;
    /**
     * 转向头灯
     */
    @Excel(name = "转向头灯")
    private String signal_headlights;
    /**
     * 前雾灯
     */
    @Excel(name = "前雾灯")
    private String fog_lamp;
    /**
     * 前大灯雨雾模式
     */
    @Excel(name = "前大灯雨雾模式")
    private String headlamp_rain;
    /**
     * 大灯高度可调
     */
    @Excel(name = "大灯高度可调")
    private String headlamp_height;
    /**
     * 大灯延时关闭
     */
    @Excel(name = "大灯延时关闭")
    private String delay_off;
    /**
     * 大灯清洗装置
     */
    @Excel(name = "大灯清洗装置")
    private String cleaning_device;
    /**
     * 触摸式阅读灯
     */
    @Excel(name = "触摸式阅读灯")
    private String reading_lamp;
    /**
     * 车内氛围灯
     */
    @Excel(name = "车内氛围灯")
    private String atmosphere_lamp;
    /**
     * 近光/远光/前雾灯
     */
    @Excel(name = "近光/远光/前雾灯")
    private String low_high_front_lamps;
    /**
     * 防空灯
     */
    @Excel(name = "防空灯")
    private String defense_lamp;
    /**
     * 地图阅读灯
     */
    @Excel(name = "地图阅读灯")
    private String maoreading_lamp;
    /**
     * 前-后电动车窗
     */
    @Excel(name = "前-后电动车窗")
    private String power_window;
    /**
     * 车窗一键升降功能
     */
    @Excel(name = "车窗一键升降功能")
    private String one_function;
    /**
     * 车窗防夹手功能
     */
    @Excel(name = "车窗防夹手功能")
    private String anti_pinch;
    /**
     * 防紫外线玻璃
     */
    @Excel(name = "防紫外线玻璃")
    private String resistant_glass;
    /**
     * 多层隔音玻璃
     */
    @Excel(name = "多层隔音玻璃")
    private String insulation_glass;
    /**
     * 后视镜电动调节
     */
    @Excel(name = "后视镜电动调节")
    private String rearview_mirror;
    /**
     * 后视镜加热
     */
    @Excel(name = "后视镜加热")
    private String mirror_heating;
    /**
     * 内后视镜防眩目
     */
    @Excel(name = "内后视镜防眩目")
    private String anti_glare;
    /**
     * 外后视镜自动防眩目
     */
    @Excel(name = "外后视镜自动防眩目")
    private String exterior_rearview;
    /**
     * 流媒体后视镜
     */
    @Excel(name = "流媒体后视镜")
    private String streaming_media;
    /**
     * 多媒体后视镜
     */
    @Excel(name = "多媒体后视镜")
    private String multimedia_rearview;
    /**
     * 后视镜电动折叠
     */
    @Excel(name = "后视镜电动折叠")
    private String mirror_fold;
    /**
     * 后视镜记忆
     */
    @Excel(name = "后视镜记忆")
    private String mirror_memory;
    /**
     * 外后视镜锁车自动折叠
     */
    @Excel(name = "外后视镜锁车自动折叠")
    private String automatic_folding;
    /**
     * 外后视镜倒车自动下翻
     */
    @Excel(name = "外后视镜倒车自动下翻")
    private String mirror_automatically;
    /**
     * 后风挡遮阳帘
     */
    @Excel(name = "后风挡遮阳帘")
    private String windshield_sunshade;
    /**
     * 后排侧遮阳帘
     */
    @Excel(name = "后排侧遮阳帘")
    private String sun_blind;
    /**
     * 后排侧隐私玻璃
     */
    @Excel(name = "后排侧隐私玻璃")
    private String privacy_glass;
    /**
     * 遮阳板化妆镜
     */
    @Excel(name = "遮阳板化妆镜")
    private String vanity_mirror;
    /**
     * 遮阳板化妆镜照明功能
     */
    @Excel(name = "遮阳板化妆镜照明功能")
    private String lighting_function;
    /**
     * 后雨刷
     */
    @Excel(name = "后雨刷")
    private String rear_wiper;
    /**
     * 速度感应雨刷
     */
    @Excel(name = "速度感应雨刷")
    private String speed_sensing;
    /**
     * 雨量感应雨刷
     */
    @Excel(name = "雨量感应雨刷")
    private String rain_sensing;
    /**
     * 手动空调
     */
    @Excel(name = "手动空调")
    private String air_conditioner;
    /**
     * 自动空调
     */
    @Excel(name = "自动空调")
    private String automatic_air;
    /**
     * 后排独立空调
     */
    @Excel(name = "后排独立空调")
    private String independent_air;
    /**
     * 后座出风口
     */
    @Excel(name = "后座出风口")
    private String air_outlet;
    /**
     * 温度分区控制
     */
    @Excel(name = "温度分区控制")
    private String zoning_control;
    /**
     * PM2.5过滤装置
     */
    @Excel(name = "PM2.5过滤装置")
    private String filter_unit;
    /**
     * 车载空气净化器
     */
    @Excel(name = "车载空气净化器")
    private String car_purifier;
    /**
     * 香氛装置
     */
    @Excel(name = "香氛装置")
    private String fragrance_device;
    /**
     * 负离子发生器
     */
    @Excel(name = "负离子发生器")
    private String ion_generator;
    /**
     * 车载冰箱
     */
    @Excel(name = "车载冰箱")
    private String car_refrigerator;
    /**
     * 车型
     */
    @Excel(name = "车型")
    private String model_name;
    /**
     * 系列
     */
    @Excel(name = "系列")
    private String car_series;
    /**
     * 官方指导价（元）
     */
    @Excel(name = "官方指导价（元）")
    private String official_guidance;
    /**
     * 动力
     */
    @Excel(name = "动力")
    private String car_power;
    /**
     * 主驾安全带未系提醒
     */
    @Excel(name = "主驾安全带未系提醒")
    private String not_fastened;
    /**
     * 织物座椅
     */
    @Excel(name = "织物座椅")
    private String fabric_seat;
    /**
     * 外后视镜手动折叠
     */
    @Excel(name = "外后视镜手动折叠")
    private String manual_folding;
    /**
     * 外后视镜手动调节
     */
    @Excel(name = "外后视镜手动调节")
    private String manual_adjustment;
    /**
     * 手动防眩目内后视镜
     */
    @Excel(name = "手动防眩目内后视镜")
    private String manual_anti;
    /**
     * 全尺寸备胎
     */
    @Excel(name = "全尺寸备胎")
    private String spare_tire;
    /**
     * 驱动
     */
    @Excel(name = "驱动")
    private String car_drive;
    /**
     * 前排取电口（点烟器/12V电源）
     */
    @Excel(name = "前排取电口（点烟器/12V电源）")
    private String front_row;
    /**
     * 前间歇式有骨雨刷
     */
    @Excel(name = "前间歇式有骨雨刷")
    private String bone_Wiper;
    /**
     * 前/后拖车钩
     */
    @Excel(name = "前/后拖车钩")
    private String rear_towbar;
    /**
     * 前/后轮距(mm)
     */
    @Excel(name = "前/后轮距(mm)")
    private String track_width;
    /**
     * 皮质座椅
     */
    @Excel(name = "皮质座椅")
    private String leather_seat;
    /**
     * 卤素前雾灯
     */
    @Excel(name = "卤素前雾灯")
    private String front_lamp;
    /**
     * 卤素前大灯
     */
    @Excel(name = "卤素前大灯")
    private String halogen_headlamp;
    /**
     * 驾驶座两向头枕
     */
    @Excel(name = "驾驶座两向头枕")
    private String two_way_headrest;
    /**
     * 后组合尾灯
     */
    @Excel(name = "后组合尾灯")
    private String tail_lamp;
    /**
     * 高位刹车灯
     */
    @Excel(name = "高位刹车灯")
    private String stop_lamp;
    /**
     * 副驾驶座两向头枕
     */
    @Excel(name = "副驾驶座两向头枕")
    private String front_headrest;
    /**
     * 发动机最大功率(Kw)
     */
    @Excel(name = "发动机最大功率(Kw)")
    private String engine_power;
    /**
     * 215/80R16轮胎
     */
    @Excel(name = "215/80R16轮胎")
    private String car_tire;
    /**
     * 16寸钢轮辋
     */
    @Excel(name = "16寸钢轮辋")
    private String steel_rim;
    /**
     * USB
     */
    @Excel(name = "USB")
    private String usb;

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCarConfigCode() {
        return carConfigCode;
    }

    public void setCarConfigCode(String carConfigCode) {
        this.carConfigCode = carConfigCode;
    }

    public String getCarSeriesCode() {
        return carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getManufacturer_price() {
        return manufacturer_price;
    }

    public void setManufacturer_price(String manufacturer_price) {
        this.manufacturer_price = manufacturer_price;
    }

    public String getPrice_after() {
        return price_after;
    }

    public void setPrice_after(String price_after) {
        this.price_after = price_after;
    }

    public String getCar_manufacturer() {
        return car_manufacturer;
    }

    public void setCar_manufacturer(String car_manufacturer) {
        this.car_manufacturer = car_manufacturer;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime_market() {
        return time_market;
    }

    public void setTime_market(String time_market) {
        this.time_market = time_market;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission_case() {
        return transmission_case;
    }

    public void setTransmission_case(String transmission_case) {
        this.transmission_case = transmission_case;
    }

    public String getMaximum_speed() {
        return maximum_speed;
    }

    public void setMaximum_speed(String maximum_speed) {
        this.maximum_speed = maximum_speed;
    }

    public String getOfficial_acceleration() {
        return official_acceleration;
    }

    public void setOfficial_acceleration(String official_acceleration) {
        this.official_acceleration = official_acceleration;
    }

    public String getYellow_label() {
        return yellow_label;
    }

    public void setYellow_label(String yellow_label) {
        this.yellow_label = yellow_label;
    }

    public String getVehicle_warranty() {
        return vehicle_warranty;
    }

    public void setVehicle_warranty(String vehicle_warranty) {
        this.vehicle_warranty = vehicle_warranty;
    }

    public String getLoad_mass() {
        return load_mass;
    }

    public void setLoad_mass(String load_mass) {
        this.load_mass = load_mass;
    }

    public String getTotal_mass() {
        return total_mass;
    }

    public void setTotal_mass(String total_mass) {
        this.total_mass = total_mass;
    }

    public String getMailbox_volume() {
        return mailbox_volume;
    }

    public void setMailbox_volume(String mailbox_volume) {
        this.mailbox_volume = mailbox_volume;
    }

    public String getFuel_consumption() {
        return fuel_consumption;
    }

    public void setFuel_consumption(String fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public String getStyle_name() {
        return style_name;
    }

    public void setStyle_name(String style_name) {
        this.style_name = style_name;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getVehicle_announcement() {
        return vehicle_announcement;
    }

    public void setVehicle_announcement(String vehicle_announcement) {
        this.vehicle_announcement = vehicle_announcement;
    }

    public String getChassis_announcement() {
        return chassis_announcement;
    }

    public void setChassis_announcement(String chassis_announcement) {
        this.chassis_announcement = chassis_announcement;
    }

    public String getConfiguration_code() {
        return configuration_code;
    }

    public void setConfiguration_code(String configuration_code) {
        this.configuration_code = configuration_code;
    }

    public String getEmission_standard() {
        return emission_standard;
    }

    public void setEmission_standard(String emission_standard) {
        this.emission_standard = emission_standard;
    }

    public String getCar_long_width_height() {
        return car_long_width_height;
    }

    public void setCar_long_width_height(String car_long_width_height) {
        this.car_long_width_height = car_long_width_height;
    }

    public String getCar_long() {
        return car_long;
    }

    public void setCar_long(String car_long) {
        this.car_long = car_long;
    }

    public String getCar_width() {
        return car_width;
    }

    public void setCar_width(String car_width) {
        this.car_width = car_width;
    }

    public String getCar_height() {
        return car_height;
    }

    public void setCar_height(String car_height) {
        this.car_height = car_height;
    }

    public String getCompartment_length() {
        return compartment_length;
    }

    public void setCompartment_length(String compartment_length) {
        this.compartment_length = compartment_length;
    }

    public String getCompartment_width() {
        return compartment_width;
    }

    public void setCompartment_width(String compartment_width) {
        this.compartment_width = compartment_width;
    }

    public String getCompartment_heigh() {
        return compartment_heigh;
    }

    public void setCompartment_heigh(String compartment_heigh) {
        this.compartment_heigh = compartment_heigh;
    }

    public String getCar_wheelbase() {
        return car_wheelbase;
    }

    public void setCar_wheelbase(String car_wheelbase) {
        this.car_wheelbase = car_wheelbase;
    }

    public String getFront_track() {
        return front_track;
    }

    public void setFront_track(String front_track) {
        this.front_track = front_track;
    }

    public String getRear_track() {
        return rear_track;
    }

    public void setRear_track(String rear_track) {
        this.rear_track = rear_track;
    }

    public String getMinimum_ground() {
        return minimum_ground;
    }

    public void setMinimum_ground(String minimum_ground) {
        this.minimum_ground = minimum_ground;
    }

    public String getCurb_weight() {
        return curb_weight;
    }

    public void setCurb_weight(String curb_weight) {
        this.curb_weight = curb_weight;
    }

    public String getBody_structure() {
        return body_structure;
    }

    public void setBody_structure(String body_structure) {
        this.body_structure = body_structure;
    }

    public String getNumber_doors() {
        return number_doors;
    }

    public void setNumber_doors(String number_doors) {
        this.number_doors = number_doors;
    }

    public String getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(String number_seats) {
        this.number_seats = number_seats;
    }

    public String getTank_volume() {
        return tank_volume;
    }

    public void setTank_volume(String tank_volume) {
        this.tank_volume = tank_volume;
    }

    public String getLuggage_volume() {
        return luggage_volume;
    }

    public void setLuggage_volume(String luggage_volume) {
        this.luggage_volume = luggage_volume;
    }

    public String getContainer_size() {
        return container_size;
    }

    public void setContainer_size(String container_size) {
        this.container_size = container_size;
    }

    public String getMaximum_mass() {
        return maximum_mass;
    }

    public void setMaximum_mass(String maximum_mass) {
        this.maximum_mass = maximum_mass;
    }

    public String getApproach_angle() {
        return approach_angle;
    }

    public void setApproach_angle(String approach_angle) {
        this.approach_angle = approach_angle;
    }

    public String getDeparture_angle() {
        return departure_angle;
    }

    public void setDeparture_angle(String departure_angle) {
        this.departure_angle = departure_angle;
    }

    public String getLongitudinal_angle() {
        return longitudinal_angle;
    }

    public void setLongitudinal_angle(String longitudinal_angle) {
        this.longitudinal_angle = longitudinal_angle;
    }

    public String getMaximum_angle() {
        return maximum_angle;
    }

    public void setMaximum_angle(String maximum_angle) {
        this.maximum_angle = maximum_angle;
    }

    public String getMaximum_radius() {
        return maximum_radius;
    }

    public void setMaximum_radius(String maximum_radius) {
        this.maximum_radius = maximum_radius;
    }

    public String getMaximum_depth() {
        return maximum_depth;
    }

    public void setMaximum_depth(String maximum_depth) {
        this.maximum_depth = maximum_depth;
    }

    public String getEngine_position() {
        return engine_position;
    }

    public void setEngine_position(String engine_position) {
        this.engine_position = engine_position;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public String getRated_power() {
        return rated_power;
    }

    public void setRated_power(String rated_power) {
        this.rated_power = rated_power;
    }

    public String getEngine_model() {
        return engine_model;
    }

    public void setEngine_model(String engine_model) {
        this.engine_model = engine_model;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getIntake_form() {
        return intake_form;
    }

    public void setIntake_form(String intake_form) {
        this.intake_form = intake_form;
    }

    public String getCylinder_arrangement() {
        return cylinder_arrangement;
    }

    public void setCylinder_arrangement(String cylinder_arrangement) {
        this.cylinder_arrangement = cylinder_arrangement;
    }

    public String getNumber_cylinders() {
        return number_cylinders;
    }

    public void setNumber_cylinders(String number_cylinders) {
        this.number_cylinders = number_cylinders;
    }

    public String getValve_trains() {
        return valve_trains;
    }

    public void setValve_trains(String valve_trains) {
        this.valve_trains = valve_trains;
    }

    public String getCompression_ratio() {
        return compression_ratio;
    }

    public void setCompression_ratio(String compression_ratio) {
        this.compression_ratio = compression_ratio;
    }

    public String getValve_train() {
        return valve_train;
    }

    public void setValve_train(String valve_train) {
        this.valve_train = valve_train;
    }

    public String getCylinder_bore() {
        return cylinder_bore;
    }

    public void setCylinder_bore(String cylinder_bore) {
        this.cylinder_bore = cylinder_bore;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getMaximum_horsepower() {
        return maximum_horsepower;
    }

    public void setMaximum_horsepower(String maximum_horsepower) {
        this.maximum_horsepower = maximum_horsepower;
    }

    public String getMaximum_power() {
        return maximum_power;
    }

    public void setMaximum_power(String maximum_power) {
        this.maximum_power = maximum_power;
    }

    public String getEngine_speed() {
        return engine_speed;
    }

    public void setEngine_speed(String engine_speed) {
        this.engine_speed = engine_speed;
    }

    public String getMaximum_torque() {
        return maximum_torque;
    }

    public void setMaximum_torque(String maximum_torque) {
        this.maximum_torque = maximum_torque;
    }

    public String getEngine_torque() {
        return engine_torque;
    }

    public void setEngine_torque(String engine_torque) {
        this.engine_torque = engine_torque;
    }

    public String getFuel_form() {
        return fuel_form;
    }

    public void setFuel_form(String fuel_form) {
        this.fuel_form = fuel_form;
    }

    public String getFuel_label() {
        return fuel_label;
    }

    public void setFuel_label(String fuel_label) {
        this.fuel_label = fuel_label;
    }

    public String getSupply_mode() {
        return supply_mode;
    }

    public void setSupply_mode(String supply_mode) {
        this.supply_mode = supply_mode;
    }

    public String getHead_material() {
        return head_material;
    }

    public void setHead_material(String head_material) {
        this.head_material = head_material;
    }

    public String getBlock_material() {
        return block_material;
    }

    public void setBlock_material(String block_material) {
        this.block_material = block_material;
    }

    public String getEnvironmental_standards() {
        return environmental_standards;
    }

    public void setEnvironmental_standards(String environmental_standards) {
        this.environmental_standards = environmental_standards;
    }

    public String getMotor_type() {
        return motor_type;
    }

    public void setMotor_type(String motor_type) {
        this.motor_type = motor_type;
    }

    public String getMotor_power() {
        return motor_power;
    }

    public void setMotor_power(String motor_power) {
        this.motor_power = motor_power;
    }

    public String getTotal_torque() {
        return total_torque;
    }

    public void setTotal_torque(String total_torque) {
        this.total_torque = total_torque;
    }

    public String getPower_motor() {
        return power_motor;
    }

    public void setPower_motor(String power_motor) {
        this.power_motor = power_motor;
    }

    public String getTorque_motor() {
        return torque_motor;
    }

    public void setTorque_motor(String torque_motor) {
        this.torque_motor = torque_motor;
    }

    public String getPower_front() {
        return power_front;
    }

    public void setPower_front(String power_front) {
        this.power_front = power_front;
    }

    public String getRear_motor() {
        return rear_motor;
    }

    public void setRear_motor(String rear_motor) {
        this.rear_motor = rear_motor;
    }

    public String getComprehensive_power() {
        return comprehensive_power;
    }

    public void setComprehensive_power(String comprehensive_power) {
        this.comprehensive_power = comprehensive_power;
    }

    public String getComprehensive_torque() {
        return comprehensive_torque;
    }

    public void setComprehensive_torque(String comprehensive_torque) {
        this.comprehensive_torque = comprehensive_torque;
    }

    public String getDrive_motors() {
        return drive_motors;
    }

    public void setDrive_motors(String drive_motors) {
        this.drive_motors = drive_motors;
    }

    public String getMotor_layout() {
        return motor_layout;
    }

    public void setMotor_layout(String motor_layout) {
        this.motor_layout = motor_layout;
    }

    public String getBattery_type() {
        return battery_type;
    }

    public void setBattery_type(String battery_type) {
        this.battery_type = battery_type;
    }

    public String getMileage_miit() {
        return mileage_miit;
    }

    public void setMileage_miit(String mileage_miit) {
        this.mileage_miit = mileage_miit;
    }

    public String getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(String battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(String power_consumption) {
        this.power_consumption = power_consumption;
    }

    public String getBattery_pack() {
        return battery_pack;
    }

    public void setBattery_pack(String battery_pack) {
        this.battery_pack = battery_pack;
    }

    public String getCharging_time() {
        return charging_time;
    }

    public void setCharging_time(String charging_time) {
        this.charging_time = charging_time;
    }

    public String getFast_charge() {
        return fast_charge;
    }

    public void setFast_charge(String fast_charge) {
        this.fast_charge = fast_charge;
    }

    public String getBattery_heating() {
        return battery_heating;
    }

    public void setBattery_heating(String battery_heating) {
        this.battery_heating = battery_heating;
    }

    public String getTransmission_form() {
        return transmission_form;
    }

    public void setTransmission_form(String transmission_form) {
        this.transmission_form = transmission_form;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getNumber_gears() {
        return number_gears;
    }

    public void setNumber_gears(String number_gears) {
        this.number_gears = number_gears;
    }

    public String getTransmission_type() {
        return transmission_type;
    }

    public void setTransmission_type(String transmission_type) {
        this.transmission_type = transmission_type;
    }

    public String getShift_form() {
        return shift_form;
    }

    public void setShift_form(String shift_form) {
        this.shift_form = shift_form;
    }

    public String getGearbox_brand() {
        return gearbox_brand;
    }

    public void setGearbox_brand(String gearbox_brand) {
        this.gearbox_brand = gearbox_brand;
    }

    public String getElectric_steering() {
        return electric_steering;
    }

    public void setElectric_steering(String electric_steering) {
        this.electric_steering = electric_steering;
    }

    public String getDriving_mode() {
        return driving_mode;
    }

    public void setDriving_mode(String driving_mode) {
        this.driving_mode = driving_mode;
    }

    public String getWd_form() {
        return wd_form;
    }

    public void setWd_form(String wd_form) {
        this.wd_form = wd_form;
    }

    public String getFront_type() {
        return front_type;
    }

    public void setFront_type(String front_type) {
        this.front_type = front_type;
    }

    public String getRear_type() {
        return rear_type;
    }

    public void setRear_type(String rear_type) {
        this.rear_type = rear_type;
    }

    public String getType_assistance() {
        return type_assistance;
    }

    public void setType_assistance(String type_assistance) {
        this.type_assistance = type_assistance;
    }

    public String getCar_structure() {
        return car_structure;
    }

    public void setCar_structure(String car_structure) {
        this.car_structure = car_structure;
    }

    public String getBraking_mode() {
        return braking_mode;
    }

    public void setBraking_mode(String braking_mode) {
        this.braking_mode = braking_mode;
    }

    public String getNumber_springs() {
        return number_springs;
    }

    public void setNumber_springs(String number_springs) {
        this.number_springs = number_springs;
    }

    public String getBrake_type() {
        return brake_type;
    }

    public void setBrake_type(String brake_type) {
        this.brake_type = brake_type;
    }

    public String getRear_brake() {
        return rear_brake;
    }

    public void setRear_brake(String rear_brake) {
        this.rear_brake = rear_brake;
    }

    public String getParking_type() {
        return parking_type;
    }

    public void setParking_type(String parking_type) {
        this.parking_type = parking_type;
    }

    public String getFront_specification() {
        return front_specification;
    }

    public void setFront_specification(String front_specification) {
        this.front_specification = front_specification;
    }

    public String getRear_specification() {
        return rear_specification;
    }

    public void setRear_specification(String rear_specification) {
        this.rear_specification = rear_specification;
    }

    public String getTire_brand() {
        return tire_brand;
    }

    public void setTire_brand(String tire_brand) {
        this.tire_brand = tire_brand;
    }

    public String getSpare_specification() {
        return spare_specification;
    }

    public void setSpare_specification(String spare_specification) {
        this.spare_specification = spare_specification;
    }

    public String getNot_equipped() {
        return not_equipped;
    }

    public void setNot_equipped(String not_equipped) {
        this.not_equipped = not_equipped;
    }

    public String getDriver_airbag() {
        return driver_airbag;
    }

    public void setDriver_airbag(String driver_airbag) {
        this.driver_airbag = driver_airbag;
    }

    public String getPassenger_airbag() {
        return passenger_airbag;
    }

    public void setPassenger_airbag(String passenger_airbag) {
        this.passenger_airbag = passenger_airbag;
    }

    public String getAbs_ebd() {
        return abs_ebd;
    }

    public void setAbs_ebd(String abs_ebd) {
        this.abs_ebd = abs_ebd;
    }

    public String getFront_airbag() {
        return front_airbag;
    }

    public void setFront_airbag(String front_airbag) {
        this.front_airbag = front_airbag;
    }

    public String getRear_airbag() {
        return rear_airbag;
    }

    public void setRear_airbag(String rear_airbag) {
        this.rear_airbag = rear_airbag;
    }

    public String getHead_airbag() {
        return head_airbag;
    }

    public void setHead_airbag(String head_airbag) {
        this.head_airbag = head_airbag;
    }

    public String getKnee_airbag() {
        return knee_airbag;
    }

    public void setKnee_airbag(String knee_airbag) {
        this.knee_airbag = knee_airbag;
    }

    public String getBelt_airbag() {
        return belt_airbag;
    }

    public void setBelt_airbag(String belt_airbag) {
        this.belt_airbag = belt_airbag;
    }

    public String getCenter_airbag() {
        return center_airbag;
    }

    public void setCenter_airbag(String center_airbag) {
        this.center_airbag = center_airbag;
    }

    public String getProtection_device() {
        return protection_device;
    }

    public void setProtection_device(String protection_device) {
        this.protection_device = protection_device;
    }

    public String getPressure_alarm() {
        return pressure_alarm;
    }

    public void setPressure_alarm(String pressure_alarm) {
        this.pressure_alarm = pressure_alarm;
    }

    public String getDisplay_function() {
        return display_function;
    }

    public void setDisplay_function(String display_function) {
        this.display_function = display_function;
    }

    public String getProof_tyre() {
        return proof_tyre;
    }

    public void setProof_tyre(String proof_tyre) {
        this.proof_tyre = proof_tyre;
    }

    public String getFastened_prompt() {
        return fastened_prompt;
    }

    public void setFastened_prompt(String fastened_prompt) {
        this.fastened_prompt = fastened_prompt;
    }

    public String getChild_seat() {
        return child_seat;
    }

    public void setChild_seat(String child_seat) {
        this.child_seat = child_seat;
    }

    public String getAnti_lock() {
        return anti_lock;
    }

    public void setAnti_lock(String anti_lock) {
        this.anti_lock = anti_lock;
    }

    public String getForce_distribution() {
        return force_distribution;
    }

    public void setForce_distribution(String force_distribution) {
        this.force_distribution = force_distribution;
    }

    public String getBrake_assist() {
        return brake_assist;
    }

    public void setBrake_assist(String brake_assist) {
        this.brake_assist = brake_assist;
    }

    public String getTraction_control() {
        return traction_control;
    }

    public void setTraction_control(String traction_control) {
        this.traction_control = traction_control;
    }

    public String getStability_control() {
        return stability_control;
    }

    public void setStability_control(String stability_control) {
        this.stability_control = stability_control;
    }

    public String getParallel_auxiliary() {
        return parallel_auxiliary;
    }

    public void setParallel_auxiliary(String parallel_auxiliary) {
        this.parallel_auxiliary = parallel_auxiliary;
    }

    public String getWarning_system() {
        return warning_system;
    }

    public void setWarning_system(String warning_system) {
        this.warning_system = warning_system;
    }

    public String getAssist_system() {
        return assist_system;
    }

    public void setAssist_system(String assist_system) {
        this.assist_system = assist_system;
    }

    public String getActive_braking() {
        return active_braking;
    }

    public void setActive_braking(String active_braking) {
        this.active_braking = active_braking;
    }

    public String getVision_system() {
        return vision_system;
    }

    public void setVision_system(String vision_system) {
        this.vision_system = vision_system;
    }

    public String getFatigue_tips() {
        return fatigue_tips;
    }

    public void setFatigue_tips(String fatigue_tips) {
        this.fatigue_tips = fatigue_tips;
    }

    public String getTraffic_recognition() {
        return traffic_recognition;
    }

    public void setTraffic_recognition(String traffic_recognition) {
        this.traffic_recognition = traffic_recognition;
    }

    public String getWade_system() {
        return wade_system;
    }

    public void setWade_system(String wade_system) {
        this.wade_system = wade_system;
    }

    public String getFront_radar() {
        return front_radar;
    }

    public void setFront_radar(String front_radar) {
        this.front_radar = front_radar;
    }

    public String getRear_radar() {
        return rear_radar;
    }

    public void setRear_radar(String rear_radar) {
        this.rear_radar = rear_radar;
    }

    public String getAssistance_image() {
        return assistance_image;
    }

    public void setAssistance_image(String assistance_image) {
        this.assistance_image = assistance_image;
    }

    public String getCruise_control() {
        return cruise_control;
    }

    public void setCruise_control(String cruise_control) {
        this.cruise_control = cruise_control;
    }

    public String getAdaptive_cruise() {
        return adaptive_cruise;
    }

    public void setAdaptive_cruise(String adaptive_cruise) {
        this.adaptive_cruise = adaptive_cruise;
    }

    public String getSpeed_cruise() {
        return speed_cruise;
    }

    public void setSpeed_cruise(String speed_cruise) {
        this.speed_cruise = speed_cruise;
    }

    public String getAutomatic_park() {
        return automatic_park;
    }

    public void setAutomatic_park(String automatic_park) {
        this.automatic_park = automatic_park;
    }

    public String getStop_technology() {
        return stop_technology;
    }

    public void setStop_technology(String stop_technology) {
        this.stop_technology = stop_technology;
    }

    public String getAutomatic_driving() {
        return automatic_driving;
    }

    public void setAutomatic_driving(String automatic_driving) {
        this.automatic_driving = automatic_driving;
    }

    public String getAutomatic_parking() {
        return automatic_parking;
    }

    public void setAutomatic_parking(String automatic_parking) {
        this.automatic_parking = automatic_parking;
    }

    public String getUphill_assist() {
        return uphill_assist;
    }

    public void setUphill_assist(String uphill_assist) {
        this.uphill_assist = uphill_assist;
    }

    public String getSteep_descent() {
        return steep_descent;
    }

    public void setSteep_descent(String steep_descent) {
        this.steep_descent = steep_descent;
    }

    public String getSuspension_adjustment() {
        return suspension_adjustment;
    }

    public void setSuspension_adjustment(String suspension_adjustment) {
        this.suspension_adjustment = suspension_adjustment;
    }

    public String getHeight_adjustment() {
        return height_adjustment;
    }

    public void setHeight_adjustment(String height_adjustment) {
        this.height_adjustment = height_adjustment;
    }

    public String getAir_suspension() {
        return air_suspension;
    }

    public void setAir_suspension(String air_suspension) {
        this.air_suspension = air_suspension;
    }

    public String getElectromagnetic_suspension() {
        return electromagnetic_suspension;
    }

    public void setElectromagnetic_suspension(String electromagnetic_suspension) {
        this.electromagnetic_suspension = electromagnetic_suspension;
    }

    public String getSteering_ratio() {
        return steering_ratio;
    }

    public void setSteering_ratio(String steering_ratio) {
        this.steering_ratio = steering_ratio;
    }

    public String getRear_wheel() {
        return rear_wheel;
    }

    public void setRear_wheel(String rear_wheel) {
        this.rear_wheel = rear_wheel;
    }

    public String getDriving_switching() {
        return driving_switching;
    }

    public void setDriving_switching(String driving_switching) {
        this.driving_switching = driving_switching;
    }

    public String getDifferential_lock() {
        return differential_lock;
    }

    public void setDifferential_lock(String differential_lock) {
        this.differential_lock = differential_lock;
    }

    public String getLocking_function() {
        return locking_function;
    }

    public void setLocking_function(String locking_function) {
        this.locking_function = locking_function;
    }

    public String getSlip_differential() {
        return slip_differential;
    }

    public void setSlip_differential(String slip_differential) {
        this.slip_differential = slip_differential;
    }

    public String getPower_sunroof() {
        return power_sunroof;
    }

    public void setPower_sunroof(String power_sunroof) {
        this.power_sunroof = power_sunroof;
    }


    //车辆选择

    public String getOpenable_panoramic() {
        return openable_panoramic;
    }

    public void setOpenable_panoramic(String openable_panoramic) {
        this.openable_panoramic = openable_panoramic;
    }

    public String getSide_bar() {
        return side_bar;
    }

    //基本参数

    public void setSide_bar(String side_bar) {
        this.side_bar = side_bar;
    }

    public String getFixed_roof() {
        return fixed_roof;
    }

    public void setFixed_roof(String fixed_roof) {
        this.fixed_roof = fixed_roof;
    }

    public String getSegmented_skylight() {
        return segmented_skylight;
    }

    public void setSegmented_skylight(String segmented_skylight) {
        this.segmented_skylight = segmented_skylight;
    }

    public String getSporty_kit() {
        return sporty_kit;
    }

    public void setSporty_kit(String sporty_kit) {
        this.sporty_kit = sporty_kit;
    }

    public String getAlloy_wheels() {
        return alloy_wheels;
    }

    public void setAlloy_wheels(String alloy_wheels) {
        this.alloy_wheels = alloy_wheels;
    }

    public String getElectric_door() {
        return electric_door;
    }

    public void setElectric_door(String electric_door) {
        this.electric_door = electric_door;
    }

    public String getSide_door() {
        return side_door;
    }

    public void setSide_door(String side_door) {
        this.side_door = side_door;
    }

    public String getElectric_compartment() {
        return electric_compartment;
    }

    public void setElectric_compartment(String electric_compartment) {
        this.electric_compartment = electric_compartment;
    }

    public String getInductive_trunk() {
        return inductive_trunk;
    }

    public void setInductive_trunk(String inductive_trunk) {
        this.inductive_trunk = inductive_trunk;
    }

    public String getPosition_memory() {
        return position_memory;
    }

    public void setPosition_memory(String position_memory) {
        this.position_memory = position_memory;
    }

    //车身

    public String getLuggage_rack() {
        return luggage_rack;
    }

    public void setLuggage_rack(String luggage_rack) {
        this.luggage_rack = luggage_rack;
    }

    public String getSide_pedal() {
        return side_pedal;
    }

    public void setSide_pedal(String side_pedal) {
        this.side_pedal = side_pedal;
    }

    public String getIntake_grille() {
        return intake_grille;
    }

    public void setIntake_grille(String intake_grille) {
        this.intake_grille = intake_grille;
    }

    public String getAnti_theft() {
        return anti_theft;
    }

    public void setAnti_theft(String anti_theft) {
        this.anti_theft = anti_theft;
    }

    public String getCentral_lock() {
        return central_lock;
    }

    public void setCentral_lock(String central_lock) {
        this.central_lock = central_lock;
    }

    public String getRemote_key() {
        return remote_key;
    }

    public void setRemote_key(String remote_key) {
        this.remote_key = remote_key;
    }

    public String getScreen_key() {
        return screen_key;
    }

    public void setScreen_key(String screen_key) {
        this.screen_key = screen_key;
    }

    public String getKey_bracelet() {
        return key_bracelet;
    }

    public void setKey_bracelet(String key_bracelet) {
        this.key_bracelet = key_bracelet;
    }

    public String getStart_system() {
        return start_system;
    }

    public void setStart_system(String start_system) {
        this.start_system = start_system;
    }

    public String getEntry_system() {
        return entry_system;
    }

    public void setEntry_system(String entry_system) {
        this.entry_system = entry_system;
    }

    public String getPiloted_parking() {
        return piloted_parking;
    }

    public void setPiloted_parking(String piloted_parking) {
        this.piloted_parking = piloted_parking;
    }

    public String getRemote_start() {
        return remote_start;
    }

    public void setRemote_start(String remote_start) {
        this.remote_start = remote_start;
    }

    public String getSteering_wheel() {
        return steering_wheel;
    }

    //发动机

    public void setSteering_wheel(String steering_wheel) {
        this.steering_wheel = steering_wheel;
    }

    public String getWheel_adjustment() {
        return wheel_adjustment;
    }

    public void setWheel_adjustment(String wheel_adjustment) {
        this.wheel_adjustment = wheel_adjustment;
    }

    public String getElectric_adjustment() {
        return electric_adjustment;
    }

    public void setElectric_adjustment(String electric_adjustment) {
        this.electric_adjustment = electric_adjustment;
    }

    public String getMultifunction_steering() {
        return multifunction_steering;
    }

    public void setMultifunction_steering(String multifunction_steering) {
        this.multifunction_steering = multifunction_steering;
    }

    public String getWheel_shift() {
        return wheel_shift;
    }

    public void setWheel_shift(String wheel_shift) {
        this.wheel_shift = wheel_shift;
    }

    public String getWheel_heating() {
        return wheel_heating;
    }

    public void setWheel_heating(String wheel_heating) {
        this.wheel_heating = wheel_heating;
    }

    public String getWheel_memory() {
        return wheel_memory;
    }

    public void setWheel_memory(String wheel_memory) {
        this.wheel_memory = wheel_memory;
    }

    public String getComputer_display() {
        return computer_display;
    }

    public void setComputer_display(String computer_display) {
        this.computer_display = computer_display;
    }

    public String getInstrument_panel() {
        return instrument_panel;
    }

    public void setInstrument_panel(String instrument_panel) {
        this.instrument_panel = instrument_panel;
    }

    public String getMeter_size() {
        return meter_size;
    }

    public void setMeter_size(String meter_size) {
        this.meter_size = meter_size;
    }

    public String getHud_head() {
        return hud_head;
    }

    public void setHud_head(String hud_head) {
        this.hud_head = hud_head;
    }

    public String getDash_cam() {
        return dash_cam;
    }

    public void setDash_cam(String dash_cam) {
        this.dash_cam = dash_cam;
    }

    public String getNoise_reduction() {
        return noise_reduction;
    }

    public void setNoise_reduction(String noise_reduction) {
        this.noise_reduction = noise_reduction;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getSeat_material() {
        return seat_material;
    }

    public void setSeat_material(String seat_material) {
        this.seat_material = seat_material;
    }

    public String getSports_seat() {
        return sports_seat;
    }

    public void setSports_seat(String sports_seat) {
        this.sports_seat = sports_seat;
    }

    public String getSeat_adjustment() {
        return seat_adjustment;
    }

    public void setSeat_adjustment(String seat_adjustment) {
        this.seat_adjustment = seat_adjustment;
    }

    public String getLumbar_adjustment() {
        return lumbar_adjustment;
    }

    public void setLumbar_adjustment(String lumbar_adjustment) {
        this.lumbar_adjustment = lumbar_adjustment;
    }

    public String getShoulder_adjustment() {
        return shoulder_adjustment;
    }

    public void setShoulder_adjustment(String shoulder_adjustment) {
        this.shoulder_adjustment = shoulder_adjustment;
    }

    public String getDriver_direction() {
        return driver_direction;
    }

    public void setDriver_direction(String driver_direction) {
        this.driver_direction = driver_direction;
    }

    public String getPassenger_direction() {
        return passenger_direction;
    }

    public void setPassenger_direction(String passenger_direction) {
        this.passenger_direction = passenger_direction;
    }

    public String getElectric_seat() {
        return electric_seat;
    }

    public void setElectric_seat(String electric_seat) {
        this.electric_seat = electric_seat;
    }

    //变速箱

    public String getFront_seat() {
        return front_seat;
    }

    public void setFront_seat(String front_seat) {
        this.front_seat = front_seat;
    }

    public String getAngle_adjustment() {
        return angle_adjustment;
    }

    public void setAngle_adjustment(String angle_adjustment) {
        this.angle_adjustment = angle_adjustment;
    }

    public String getSeat_movement() {
        return seat_movement;
    }

    public void setSeat_movement(String seat_movement) {
        this.seat_movement = seat_movement;
    }

    //底盘

    public String getRear_seat() {
        return rear_seat;
    }

    public void setRear_seat(String rear_seat) {
        this.rear_seat = rear_seat;
    }

    public String getBoss_key() {
        return boss_key;
    }

    public void setBoss_key(String boss_key) {
        this.boss_key = boss_key;
    }

    public String getPower_memory() {
        return power_memory;
    }

    public void setPower_memory(String power_memory) {
        this.power_memory = power_memory;
    }

    public String getSeat_heating() {
        return seat_heating;
    }

    //车轮制动

    public void setSeat_heating(String seat_heating) {
        this.seat_heating = seat_heating;
    }

    public String getSeat_ventilation() {
        return seat_ventilation;
    }

    public void setSeat_ventilation(String seat_ventilation) {
        this.seat_ventilation = seat_ventilation;
    }

    public String getSeat_massage() {
        return seat_massage;
    }

    public void setSeat_massage(String seat_massage) {
        this.seat_massage = seat_massage;
    }

    public String getIndependent_seat() {
        return independent_seat;
    }

    public void setIndependent_seat(String independent_seat) {
        this.independent_seat = independent_seat;
    }

    public String getThird_row() {
        return third_row;
    }

    public void setThird_row(String third_row) {
        this.third_row = third_row;
    }

    public String getFall_mode() {
        return fall_mode;
    }

    public void setFall_mode(String fall_mode) {
        this.fall_mode = fall_mode;
    }


    //主-被动安全装备

    public String getFront_armrest() {
        return front_armrest;
    }

    public void setFront_armrest(String front_armrest) {
        this.front_armrest = front_armrest;
    }

    public String getRear_armrest() {
        return rear_armrest;
    }

    public void setRear_armrest(String rear_armrest) {
        this.rear_armrest = rear_armrest;
    }

    public String getCup_holder() {
        return cup_holder;
    }

    public void setCup_holder(String cup_holder) {
        this.cup_holder = cup_holder;
    }

    public String getMultimedia_control() {
        return multimedia_control;
    }

    public void setMultimedia_control(String multimedia_control) {
        this.multimedia_control = multimedia_control;
    }

    public String getRefrigeration_holder() {
        return refrigeration_holder;
    }

    public void setRefrigeration_holder(String refrigeration_holder) {
        this.refrigeration_holder = refrigeration_holder;
    }

    public String getDriving_manual() {
        return driving_manual;
    }

    public void setDriving_manual(String driving_manual) {
        this.driving_manual = driving_manual;
    }

    public String getCopilot_manual() {
        return copilot_manual;
    }

    public void setCopilot_manual(String copilot_manual) {
        this.copilot_manual = copilot_manual;
    }

    public String getNavigation_system() {
        return navigation_system;
    }

    public void setNavigation_system(String navigation_system) {
        this.navigation_system = navigation_system;
    }

    public String getTraffic_information() {
        return traffic_information;
    }

    public void setTraffic_information(String traffic_information) {
        this.traffic_information = traffic_information;
    }

    public String getRescue_call() {
        return rescue_call;
    }

    public void setRescue_call(String rescue_call) {
        this.rescue_call = rescue_call;
    }

    public String getCenter_console() {
        return center_console;
    }

    public void setCenter_console(String center_console) {
        this.center_console = center_console;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getSplit_screen() {
        return split_screen;
    }

    public void setSplit_screen(String split_screen) {
        this.split_screen = split_screen;
    }

    //辅助-操控配置

    public String getCar_phone() {
        return car_phone;
    }

    public void setCar_phone(String car_phone) {
        this.car_phone = car_phone;
    }

    public String getVoice_control() {
        return voice_control;
    }

    public void setVoice_control(String voice_control) {
        this.voice_control = voice_control;
    }

    public String getGesture_control() {
        return gesture_control;
    }

    public void setGesture_control(String gesture_control) {
        this.gesture_control = gesture_control;
    }

    public String getInternet_vehicles() {
        return internet_vehicles;
    }

    public void setInternet_vehicles(String internet_vehicles) {
        this.internet_vehicles = internet_vehicles;
    }

    public String getPhone_interconnection() {
        return phone_interconnection;
    }

    public void setPhone_interconnection(String phone_interconnection) {
        this.phone_interconnection = phone_interconnection;
    }

    public String getCar_tv() {
        return car_tv;
    }

    public void setCar_tv(String car_tv) {
        this.car_tv = car_tv;
    }

    public String getRear_lcd() {
        return rear_lcd;
    }

    public void setRear_lcd(String rear_lcd) {
        this.rear_lcd = rear_lcd;
    }

    public String getPower_supply() {
        return power_supply;
    }

    public void setPower_supply(String power_supply) {
        this.power_supply = power_supply;
    }

    public String getSource_interface() {
        return source_interface;
    }

    public void setSource_interface(String source_interface) {
        this.source_interface = source_interface;
    }

    public String getUsb_interfaces() {
        return usb_interfaces;
    }

    public void setUsb_interfaces(String usb_interfaces) {
        this.usb_interfaces = usb_interfaces;
    }

    public String getCd_dvd() {
        return cd_dvd;
    }

    public void setCd_dvd(String cd_dvd) {
        this.cd_dvd = cd_dvd;
    }

    public String getElectronic_clock() {
        return electronic_clock;
    }

    //外部-防盗配置

    public void setElectronic_clock(String electronic_clock) {
        this.electronic_clock = electronic_clock;
    }

    public String getRadio_usb() {
        return radio_usb;
    }

    public void setRadio_usb(String radio_usb) {
        this.radio_usb = radio_usb;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getSpeaker_brand() {
        return speaker_brand;
    }

    public void setSpeaker_brand(String speaker_brand) {
        this.speaker_brand = speaker_brand;
    }

    public String getNumber_speakers() {
        return number_speakers;
    }

    public void setNumber_speakers(String number_speakers) {
        this.number_speakers = number_speakers;
    }

    public String getRemote_upgrade() {
        return remote_upgrade;
    }

    public void setRemote_upgrade(String remote_upgrade) {
        this.remote_upgrade = remote_upgrade;
    }

    public String getDipped_headlight() {
        return dipped_headlight;
    }

    public void setDipped_headlight(String dipped_headlight) {
        this.dipped_headlight = dipped_headlight;
    }

    public String getHigh_beam() {
        return high_beam;
    }

    public void setHigh_beam(String high_beam) {
        this.high_beam = high_beam;
    }

    public String getRunning_lights() {
        return running_lights;
    }

    public void setRunning_lights(String running_lights) {
        this.running_lights = running_lights;
    }

    public String getAdaptive_beam() {
        return adaptive_beam;
    }

    public void setAdaptive_beam(String adaptive_beam) {
        this.adaptive_beam = adaptive_beam;
    }

    public String getAutomatic_headlamp() {
        return automatic_headlamp;
    }

    public void setAutomatic_headlamp(String automatic_headlamp) {
        this.automatic_headlamp = automatic_headlamp;
    }

    public String getAssist_lamp() {
        return assist_lamp;
    }

    public void setAssist_lamp(String assist_lamp) {
        this.assist_lamp = assist_lamp;
    }

    public String getSignal_headlights() {
        return signal_headlights;
    }


    //内部配置

    public void setSignal_headlights(String signal_headlights) {
        this.signal_headlights = signal_headlights;
    }

    public String getFog_lamp() {
        return fog_lamp;
    }

    public void setFog_lamp(String fog_lamp) {
        this.fog_lamp = fog_lamp;
    }

    public String getHeadlamp_rain() {
        return headlamp_rain;
    }

    public void setHeadlamp_rain(String headlamp_rain) {
        this.headlamp_rain = headlamp_rain;
    }

    public String getHeadlamp_height() {
        return headlamp_height;
    }

    public void setHeadlamp_height(String headlamp_height) {
        this.headlamp_height = headlamp_height;
    }

    public String getDelay_off() {
        return delay_off;
    }

    public void setDelay_off(String delay_off) {
        this.delay_off = delay_off;
    }

    public String getCleaning_device() {
        return cleaning_device;
    }

    public void setCleaning_device(String cleaning_device) {
        this.cleaning_device = cleaning_device;
    }

    public String getReading_lamp() {
        return reading_lamp;
    }

    public void setReading_lamp(String reading_lamp) {
        this.reading_lamp = reading_lamp;
    }

    public String getAtmosphere_lamp() {
        return atmosphere_lamp;
    }

    //座椅配置

    public void setAtmosphere_lamp(String atmosphere_lamp) {
        this.atmosphere_lamp = atmosphere_lamp;
    }

    public String getLow_high_front_lamps() {
        return low_high_front_lamps;
    }

    public void setLow_high_front_lamps(String low_high_front_lamps) {
        this.low_high_front_lamps = low_high_front_lamps;
    }

    public String getDefense_lamp() {
        return defense_lamp;
    }

    public void setDefense_lamp(String defense_lamp) {
        this.defense_lamp = defense_lamp;
    }

    public String getMaoreading_lamp() {
        return maoreading_lamp;
    }

    public void setMaoreading_lamp(String maoreading_lamp) {
        this.maoreading_lamp = maoreading_lamp;
    }

    public String getPower_window() {
        return power_window;
    }

    public void setPower_window(String power_window) {
        this.power_window = power_window;
    }

    public String getOne_function() {
        return one_function;
    }

    public void setOne_function(String one_function) {
        this.one_function = one_function;
    }

    public String getAnti_pinch() {
        return anti_pinch;
    }

    public void setAnti_pinch(String anti_pinch) {
        this.anti_pinch = anti_pinch;
    }

    public String getResistant_glass() {
        return resistant_glass;
    }

    public void setResistant_glass(String resistant_glass) {
        this.resistant_glass = resistant_glass;
    }

    public String getInsulation_glass() {
        return insulation_glass;
    }

    public void setInsulation_glass(String insulation_glass) {
        this.insulation_glass = insulation_glass;
    }

    public String getRearview_mirror() {
        return rearview_mirror;
    }

    public void setRearview_mirror(String rearview_mirror) {
        this.rearview_mirror = rearview_mirror;
    }

    public String getMirror_heating() {
        return mirror_heating;
    }

    public void setMirror_heating(String mirror_heating) {
        this.mirror_heating = mirror_heating;
    }

    public String getAnti_glare() {
        return anti_glare;
    }

    public void setAnti_glare(String anti_glare) {
        this.anti_glare = anti_glare;
    }

    public String getExterior_rearview() {
        return exterior_rearview;
    }

    public void setExterior_rearview(String exterior_rearview) {
        this.exterior_rearview = exterior_rearview;
    }

    public String getStreaming_media() {
        return streaming_media;
    }

    public void setStreaming_media(String streaming_media) {
        this.streaming_media = streaming_media;
    }

    //多媒体配置

    public String getMultimedia_rearview() {
        return multimedia_rearview;
    }

    public void setMultimedia_rearview(String multimedia_rearview) {
        this.multimedia_rearview = multimedia_rearview;
    }

    public String getMirror_fold() {
        return mirror_fold;
    }

    public void setMirror_fold(String mirror_fold) {
        this.mirror_fold = mirror_fold;
    }

    public String getMirror_memory() {
        return mirror_memory;
    }

    public void setMirror_memory(String mirror_memory) {
        this.mirror_memory = mirror_memory;
    }

    public String getAutomatic_folding() {
        return automatic_folding;
    }

    public void setAutomatic_folding(String automatic_folding) {
        this.automatic_folding = automatic_folding;
    }

    public String getMirror_automatically() {
        return mirror_automatically;
    }

    public void setMirror_automatically(String mirror_automatically) {
        this.mirror_automatically = mirror_automatically;
    }

    public String getWindshield_sunshade() {
        return windshield_sunshade;
    }

    public void setWindshield_sunshade(String windshield_sunshade) {
        this.windshield_sunshade = windshield_sunshade;
    }

    public String getSun_blind() {
        return sun_blind;
    }

    public void setSun_blind(String sun_blind) {
        this.sun_blind = sun_blind;
    }

    public String getPrivacy_glass() {
        return privacy_glass;
    }

    public void setPrivacy_glass(String privacy_glass) {
        this.privacy_glass = privacy_glass;
    }

    public String getVanity_mirror() {
        return vanity_mirror;
    }

    public void setVanity_mirror(String vanity_mirror) {
        this.vanity_mirror = vanity_mirror;
    }

    public String getLighting_function() {
        return lighting_function;
    }

    public void setLighting_function(String lighting_function) {
        this.lighting_function = lighting_function;
    }

    public String getRear_wiper() {
        return rear_wiper;
    }

    public void setRear_wiper(String rear_wiper) {
        this.rear_wiper = rear_wiper;
    }

    public String getSpeed_sensing() {
        return speed_sensing;
    }


    //灯光配置

    public void setSpeed_sensing(String speed_sensing) {
        this.speed_sensing = speed_sensing;
    }

    public String getRain_sensing() {
        return rain_sensing;
    }

    public void setRain_sensing(String rain_sensing) {
        this.rain_sensing = rain_sensing;
    }

    public String getAir_conditioner() {
        return air_conditioner;
    }

    public void setAir_conditioner(String air_conditioner) {
        this.air_conditioner = air_conditioner;
    }

    public String getAutomatic_air() {
        return automatic_air;
    }

    public void setAutomatic_air(String automatic_air) {
        this.automatic_air = automatic_air;
    }

    public String getIndependent_air() {
        return independent_air;
    }

    public void setIndependent_air(String independent_air) {
        this.independent_air = independent_air;
    }

    public String getAir_outlet() {
        return air_outlet;
    }

    public void setAir_outlet(String air_outlet) {
        this.air_outlet = air_outlet;
    }

    public String getZoning_control() {
        return zoning_control;
    }

    public void setZoning_control(String zoning_control) {
        this.zoning_control = zoning_control;
    }

    public String getFilter_unit() {
        return filter_unit;
    }

    public void setFilter_unit(String filter_unit) {
        this.filter_unit = filter_unit;
    }

    public String getCar_purifier() {
        return car_purifier;
    }

    public void setCar_purifier(String car_purifier) {
        this.car_purifier = car_purifier;
    }

    //玻璃-后视镜

    public String getFragrance_device() {
        return fragrance_device;
    }

    public void setFragrance_device(String fragrance_device) {
        this.fragrance_device = fragrance_device;
    }

    public String getIon_generator() {
        return ion_generator;
    }

    public void setIon_generator(String ion_generator) {
        this.ion_generator = ion_generator;
    }

    public String getCar_refrigerator() {
        return car_refrigerator;
    }

    public void setCar_refrigerator(String car_refrigerator) {
        this.car_refrigerator = car_refrigerator;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }


    public String getCar_series() {
        return car_series;
    }

    public void setCar_series(String car_series) {
        this.car_series = car_series;
    }

    public String getOfficial_guidance() {
        return official_guidance;
    }

    public void setOfficial_guidance(String official_guidance) {
        this.official_guidance = official_guidance;
    }

    public String getCar_power() {
        return car_power;
    }

    public void setCar_power(String car_power) {
        this.car_power = car_power;
    }

    public String getNot_fastened() {
        return not_fastened;
    }

    public void setNot_fastened(String not_fastened) {
        this.not_fastened = not_fastened;
    }

    public String getFabric_seat() {
        return fabric_seat;
    }

    public void setFabric_seat(String fabric_seat) {
        this.fabric_seat = fabric_seat;
    }

    public String getManual_folding() {
        return manual_folding;
    }

    public void setManual_folding(String manual_folding) {
        this.manual_folding = manual_folding;
    }

    public String getManual_adjustment() {
        return manual_adjustment;
    }

    //空调-冰箱

    public void setManual_adjustment(String manual_adjustment) {
        this.manual_adjustment = manual_adjustment;
    }

    public String getManual_anti() {
        return manual_anti;
    }

    public void setManual_anti(String manual_anti) {
        this.manual_anti = manual_anti;
    }

    public String getSpare_tire() {
        return spare_tire;
    }

    public void setSpare_tire(String spare_tire) {
        this.spare_tire = spare_tire;
    }

    public String getCar_drive() {
        return car_drive;
    }

    public void setCar_drive(String car_drive) {
        this.car_drive = car_drive;
    }

    public String getFront_row() {
        return front_row;
    }

    public void setFront_row(String front_row) {
        this.front_row = front_row;
    }

    public String getBone_Wiper() {
        return bone_Wiper;
    }

    public void setBone_Wiper(String bone_Wiper) {
        this.bone_Wiper = bone_Wiper;
    }

    public String getRear_towbar() {
        return rear_towbar;
    }

    public void setRear_towbar(String rear_towbar) {
        this.rear_towbar = rear_towbar;
    }

    public String getTrack_width() {
        return track_width;
    }

    public void setTrack_width(String track_width) {
        this.track_width = track_width;
    }

    public String getLeather_seat() {
        return leather_seat;
    }

    public void setLeather_seat(String leather_seat) {
        this.leather_seat = leather_seat;
    }

    public String getFront_lamp() {
        return front_lamp;
    }

    public void setFront_lamp(String front_lamp) {
        this.front_lamp = front_lamp;
    }

    public String getHalogen_headlamp() {
        return halogen_headlamp;
    }

    public void setHalogen_headlamp(String halogen_headlamp) {
        this.halogen_headlamp = halogen_headlamp;
    }

    public String getTwo_way_headrest() {
        return two_way_headrest;
    }

    public void setTwo_way_headrest(String two_way_headrest) {
        this.two_way_headrest = two_way_headrest;
    }

    public String getTail_lamp() {
        return tail_lamp;
    }

    public void setTail_lamp(String tail_lamp) {
        this.tail_lamp = tail_lamp;
    }

    public String getStop_lamp() {
        return stop_lamp;
    }

    public void setStop_lamp(String stop_lamp) {
        this.stop_lamp = stop_lamp;
    }

    public String getFront_headrest() {
        return front_headrest;
    }

    public void setFront_headrest(String front_headrest) {
        this.front_headrest = front_headrest;
    }

    public String getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(String engine_power) {
        this.engine_power = engine_power;
    }

    public String getCar_tire() {
        return car_tire;
    }

    public void setCar_tire(String car_tire) {
        this.car_tire = car_tire;
    }

    public String getSteel_rim() {
        return steel_rim;
    }

    public void setSteel_rim(String steel_rim) {
        this.steel_rim = steel_rim;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(String transmissions) {
        this.transmissions = transmissions;
    }

    @Override
    public String toString() {
        return "BawBaseCarConfigParamDeserialization{" +
                "carConfigCode='" + carConfigCode + '\'' +
                ", carSeriesCode='" + carSeriesCode + '\'' +
                ", car_model='" + car_model + '\'' +
                ", manufacturer_price='" + manufacturer_price + '\'' +
                ", price_after='" + price_after + '\'' +
                ", car_manufacturer='" + car_manufacturer + '\'' +
                ", level='" + level + '\'' +
                ", time_market='" + time_market + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission_case='" + transmission_case + '\'' +
                ", maximum_speed='" + maximum_speed + '\'' +
                ", official_acceleration='" + official_acceleration + '\'' +
                ", yellow_label='" + yellow_label + '\'' +
                ", vehicle_warranty='" + vehicle_warranty + '\'' +
                ", load_mass='" + load_mass + '\'' +
                ", total_mass='" + total_mass + '\'' +
                ", mailbox_volume='" + mailbox_volume + '\'' +
                ", fuel_consumption='" + fuel_consumption + '\'' +
                ", style_name='" + style_name + '\'' +
                ", car_color='" + car_color + '\'' +
                ", vehicle_announcement='" + vehicle_announcement + '\'' +
                ", chassis_announcement='" + chassis_announcement + '\'' +
                ", configuration_code='" + configuration_code + '\'' +
                ", emission_standard='" + emission_standard + '\'' +
                ", car_long_width_height='" + car_long_width_height + '\'' +
                ", car_long='" + car_long + '\'' +
                ", car_width='" + car_width + '\'' +
                ", car_height='" + car_height + '\'' +
                ", compartment_length='" + compartment_length + '\'' +
                ", compartment_width='" + compartment_width + '\'' +
                ", compartment_heigh='" + compartment_heigh + '\'' +
                ", car_wheelbase='" + car_wheelbase + '\'' +
                ", front_track='" + front_track + '\'' +
                ", rear_track='" + rear_track + '\'' +
                ", minimum_ground='" + minimum_ground + '\'' +
                ", curb_weight='" + curb_weight + '\'' +
                ", body_structure='" + body_structure + '\'' +
                ", number_doors='" + number_doors + '\'' +
                ", number_seats='" + number_seats + '\'' +
                ", tank_volume='" + tank_volume + '\'' +
                ", luggage_volume='" + luggage_volume + '\'' +
                ", container_size='" + container_size + '\'' +
                ", maximum_mass='" + maximum_mass + '\'' +
                ", approach_angle='" + approach_angle + '\'' +
                ", departure_angle='" + departure_angle + '\'' +
                ", longitudinal_angle='" + longitudinal_angle + '\'' +
                ", maximum_angle='" + maximum_angle + '\'' +
                ", maximum_radius='" + maximum_radius + '\'' +
                ", maximum_depth='" + maximum_depth + '\'' +
                ", engine_position='" + engine_position + '\'' +
                ", engine_type='" + engine_type + '\'' +
                ", rated_power='" + rated_power + '\'' +
                ", engine_model='" + engine_model + '\'' +
                ", displacement='" + displacement + '\'' +
                ", intake_form='" + intake_form + '\'' +
                ", cylinder_arrangement='" + cylinder_arrangement + '\'' +
                ", number_cylinders='" + number_cylinders + '\'' +
                ", valve_trains='" + valve_trains + '\'' +
                ", compression_ratio='" + compression_ratio + '\'' +
                ", valve_train='" + valve_train + '\'' +
                ", cylinder_bore='" + cylinder_bore + '\'' +
                ", trip='" + trip + '\'' +
                ", maximum_horsepower='" + maximum_horsepower + '\'' +
                ", maximum_power='" + maximum_power + '\'' +
                ", engine_speed='" + engine_speed + '\'' +
                ", maximum_torque='" + maximum_torque + '\'' +
                ", engine_torque='" + engine_torque + '\'' +
                ", fuel_form='" + fuel_form + '\'' +
                ", fuel_label='" + fuel_label + '\'' +
                ", supply_mode='" + supply_mode + '\'' +
                ", head_material='" + head_material + '\'' +
                ", block_material='" + block_material + '\'' +
                ", environmental_standards='" + environmental_standards + '\'' +
                ", motor_type='" + motor_type + '\'' +
                ", motor_power='" + motor_power + '\'' +
                ", total_torque='" + total_torque + '\'' +
                ", power_motor='" + power_motor + '\'' +
                ", torque_motor='" + torque_motor + '\'' +
                ", power_front='" + power_front + '\'' +
                ", rear_motor='" + rear_motor + '\'' +
                ", comprehensive_power='" + comprehensive_power + '\'' +
                ", comprehensive_torque='" + comprehensive_torque + '\'' +
                ", drive_motors='" + drive_motors + '\'' +
                ", motor_layout='" + motor_layout + '\'' +
                ", battery_type='" + battery_type + '\'' +
                ", mileage_miit='" + mileage_miit + '\'' +
                ", battery_capacity='" + battery_capacity + '\'' +
                ", power_consumption='" + power_consumption + '\'' +
                ", battery_pack='" + battery_pack + '\'' +
                ", charging_time='" + charging_time + '\'' +
                ", fast_charge='" + fast_charge + '\'' +
                ", battery_heating='" + battery_heating + '\'' +
                ", transmission_form='" + transmission_form + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", number_gears='" + number_gears + '\'' +
                ", transmission_type='" + transmission_type + '\'' +
                ", shift_form='" + shift_form + '\'' +
                ", gearbox_brand='" + gearbox_brand + '\'' +
                ", electric_steering='" + electric_steering + '\'' +
                ", driving_mode='" + driving_mode + '\'' +
                ", wd_form='" + wd_form + '\'' +
                ", front_type='" + front_type + '\'' +
                ", rear_type='" + rear_type + '\'' +
                ", type_assistance='" + type_assistance + '\'' +
                ", car_structure='" + car_structure + '\'' +
                ", braking_mode='" + braking_mode + '\'' +
                ", number_springs='" + number_springs + '\'' +
                ", brake_type='" + brake_type + '\'' +
                ", rear_brake='" + rear_brake + '\'' +
                ", parking_type='" + parking_type + '\'' +
                ", front_specification='" + front_specification + '\'' +
                ", rear_specification='" + rear_specification + '\'' +
                ", tire_brand='" + tire_brand + '\'' +
                ", spare_specification='" + spare_specification + '\'' +
                ", not_equipped='" + not_equipped + '\'' +
                ", driver_airbag='" + driver_airbag + '\'' +
                ", passenger_airbag='" + passenger_airbag + '\'' +
                ", abs_ebd='" + abs_ebd + '\'' +
                ", front_airbag='" + front_airbag + '\'' +
                ", rear_airbag='" + rear_airbag + '\'' +
                ", head_airbag='" + head_airbag + '\'' +
                ", knee_airbag='" + knee_airbag + '\'' +
                ", belt_airbag='" + belt_airbag + '\'' +
                ", center_airbag='" + center_airbag + '\'' +
                ", protection_device='" + protection_device + '\'' +
                ", pressure_alarm='" + pressure_alarm + '\'' +
                ", display_function='" + display_function + '\'' +
                ", proof_tyre='" + proof_tyre + '\'' +
                ", fastened_prompt='" + fastened_prompt + '\'' +
                ", child_seat='" + child_seat + '\'' +
                ", anti_lock='" + anti_lock + '\'' +
                ", force_distribution='" + force_distribution + '\'' +
                ", brake_assist='" + brake_assist + '\'' +
                ", traction_control='" + traction_control + '\'' +
                ", stability_control='" + stability_control + '\'' +
                ", parallel_auxiliary='" + parallel_auxiliary + '\'' +
                ", warning_system='" + warning_system + '\'' +
                ", assist_system='" + assist_system + '\'' +
                ", active_braking='" + active_braking + '\'' +
                ", vision_system='" + vision_system + '\'' +
                ", fatigue_tips='" + fatigue_tips + '\'' +
                ", traffic_recognition='" + traffic_recognition + '\'' +
                ", wade_system='" + wade_system + '\'' +
                ", front_radar='" + front_radar + '\'' +
                ", rear_radar='" + rear_radar + '\'' +
                ", assistance_image='" + assistance_image + '\'' +
                ", cruise_control='" + cruise_control + '\'' +
                ", adaptive_cruise='" + adaptive_cruise + '\'' +
                ", speed_cruise='" + speed_cruise + '\'' +
                ", automatic_park='" + automatic_park + '\'' +
                ", stop_technology='" + stop_technology + '\'' +
                ", automatic_driving='" + automatic_driving + '\'' +
                ", automatic_parking='" + automatic_parking + '\'' +
                ", uphill_assist='" + uphill_assist + '\'' +
                ", steep_descent='" + steep_descent + '\'' +
                ", suspension_adjustment='" + suspension_adjustment + '\'' +
                ", height_adjustment='" + height_adjustment + '\'' +
                ", air_suspension='" + air_suspension + '\'' +
                ", electromagnetic_suspension='" + electromagnetic_suspension + '\'' +
                ", steering_ratio='" + steering_ratio + '\'' +
                ", rear_wheel='" + rear_wheel + '\'' +
                ", driving_switching='" + driving_switching + '\'' +
                ", differential_lock='" + differential_lock + '\'' +
                ", locking_function='" + locking_function + '\'' +
                ", slip_differential='" + slip_differential + '\'' +
                ", power_sunroof='" + power_sunroof + '\'' +
                ", openable_panoramic='" + openable_panoramic + '\'' +
                ", side_bar='" + side_bar + '\'' +
                ", fixed_roof='" + fixed_roof + '\'' +
                ", segmented_skylight='" + segmented_skylight + '\'' +
                ", sporty_kit='" + sporty_kit + '\'' +
                ", alloy_wheels='" + alloy_wheels + '\'' +
                ", electric_door='" + electric_door + '\'' +
                ", side_door='" + side_door + '\'' +
                ", electric_compartment='" + electric_compartment + '\'' +
                ", inductive_trunk='" + inductive_trunk + '\'' +
                ", position_memory='" + position_memory + '\'' +
                ", luggage_rack='" + luggage_rack + '\'' +
                ", side_pedal='" + side_pedal + '\'' +
                ", intake_grille='" + intake_grille + '\'' +
                ", anti_theft='" + anti_theft + '\'' +
                ", central_lock='" + central_lock + '\'' +
                ", remote_key='" + remote_key + '\'' +
                ", screen_key='" + screen_key + '\'' +
                ", key_bracelet='" + key_bracelet + '\'' +
                ", start_system='" + start_system + '\'' +
                ", entry_system='" + entry_system + '\'' +
                ", piloted_parking='" + piloted_parking + '\'' +
                ", remote_start='" + remote_start + '\'' +
                ", steering_wheel='" + steering_wheel + '\'' +
                ", wheel_adjustment='" + wheel_adjustment + '\'' +
                ", electric_adjustment='" + electric_adjustment + '\'' +
                ", multifunction_steering='" + multifunction_steering + '\'' +
                ", wheel_shift='" + wheel_shift + '\'' +
                ", wheel_heating='" + wheel_heating + '\'' +
                ", wheel_memory='" + wheel_memory + '\'' +
                ", computer_display='" + computer_display + '\'' +
                ", instrument_panel='" + instrument_panel + '\'' +
                ", meter_size='" + meter_size + '\'' +
                ", hud_head='" + hud_head + '\'' +
                ", dash_cam='" + dash_cam + '\'' +
                ", noise_reduction='" + noise_reduction + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", seat_material='" + seat_material + '\'' +
                ", sports_seat='" + sports_seat + '\'' +
                ", seat_adjustment='" + seat_adjustment + '\'' +
                ", lumbar_adjustment='" + lumbar_adjustment + '\'' +
                ", shoulder_adjustment='" + shoulder_adjustment + '\'' +
                ", driver_direction='" + driver_direction + '\'' +
                ", passenger_direction='" + passenger_direction + '\'' +
                ", electric_seat='" + electric_seat + '\'' +
                ", front_seat='" + front_seat + '\'' +
                ", angle_adjustment='" + angle_adjustment + '\'' +
                ", seat_movement='" + seat_movement + '\'' +
                ", rear_seat='" + rear_seat + '\'' +
                ", boss_key='" + boss_key + '\'' +
                ", power_memory='" + power_memory + '\'' +
                ", seat_heating='" + seat_heating + '\'' +
                ", seat_ventilation='" + seat_ventilation + '\'' +
                ", seat_massage='" + seat_massage + '\'' +
                ", independent_seat='" + independent_seat + '\'' +
                ", third_row='" + third_row + '\'' +
                ", fall_mode='" + fall_mode + '\'' +
                ", front_armrest='" + front_armrest + '\'' +
                ", rear_armrest='" + rear_armrest + '\'' +
                ", cup_holder='" + cup_holder + '\'' +
                ", multimedia_control='" + multimedia_control + '\'' +
                ", refrigeration_holder='" + refrigeration_holder + '\'' +
                ", driving_manual='" + driving_manual + '\'' +
                ", copilot_manual='" + copilot_manual + '\'' +
                ", navigation_system='" + navigation_system + '\'' +
                ", traffic_information='" + traffic_information + '\'' +
                ", rescue_call='" + rescue_call + '\'' +
                ", center_console='" + center_console + '\'' +
                ", screen_size='" + screen_size + '\'' +
                ", split_screen='" + split_screen + '\'' +
                ", car_phone='" + car_phone + '\'' +
                ", voice_control='" + voice_control + '\'' +
                ", gesture_control='" + gesture_control + '\'' +
                ", internet_vehicles='" + internet_vehicles + '\'' +
                ", phone_interconnection='" + phone_interconnection + '\'' +
                ", car_tv='" + car_tv + '\'' +
                ", rear_lcd='" + rear_lcd + '\'' +
                ", power_supply='" + power_supply + '\'' +
                ", source_interface='" + source_interface + '\'' +
                ", usb_interfaces='" + usb_interfaces + '\'' +
                ", cd_dvd='" + cd_dvd + '\'' +
                ", electronic_clock='" + electronic_clock + '\'' +
                ", radio_usb='" + radio_usb + '\'' +
                ", radio='" + radio + '\'' +
                ", speaker_brand='" + speaker_brand + '\'' +
                ", number_speakers='" + number_speakers + '\'' +
                ", remote_upgrade='" + remote_upgrade + '\'' +
                ", dipped_headlight='" + dipped_headlight + '\'' +
                ", high_beam='" + high_beam + '\'' +
                ", running_lights='" + running_lights + '\'' +
                ", adaptive_beam='" + adaptive_beam + '\'' +
                ", automatic_headlamp='" + automatic_headlamp + '\'' +
                ", assist_lamp='" + assist_lamp + '\'' +
                ", signal_headlights='" + signal_headlights + '\'' +
                ", fog_lamp='" + fog_lamp + '\'' +
                ", headlamp_rain='" + headlamp_rain + '\'' +
                ", headlamp_height='" + headlamp_height + '\'' +
                ", delay_off='" + delay_off + '\'' +
                ", cleaning_device='" + cleaning_device + '\'' +
                ", reading_lamp='" + reading_lamp + '\'' +
                ", atmosphere_lamp='" + atmosphere_lamp + '\'' +
                ", low_high_front_lamps='" + low_high_front_lamps + '\'' +
                ", defense_lamp='" + defense_lamp + '\'' +
                ", maoreading_lamp='" + maoreading_lamp + '\'' +
                ", power_window='" + power_window + '\'' +
                ", one_function='" + one_function + '\'' +
                ", anti_pinch='" + anti_pinch + '\'' +
                ", resistant_glass='" + resistant_glass + '\'' +
                ", insulation_glass='" + insulation_glass + '\'' +
                ", rearview_mirror='" + rearview_mirror + '\'' +
                ", mirror_heating='" + mirror_heating + '\'' +
                ", anti_glare='" + anti_glare + '\'' +
                ", exterior_rearview='" + exterior_rearview + '\'' +
                ", streaming_media='" + streaming_media + '\'' +
                ", multimedia_rearview='" + multimedia_rearview + '\'' +
                ", mirror_fold='" + mirror_fold + '\'' +
                ", mirror_memory='" + mirror_memory + '\'' +
                ", automatic_folding='" + automatic_folding + '\'' +
                ", mirror_automatically='" + mirror_automatically + '\'' +
                ", windshield_sunshade='" + windshield_sunshade + '\'' +
                ", sun_blind='" + sun_blind + '\'' +
                ", privacy_glass='" + privacy_glass + '\'' +
                ", vanity_mirror='" + vanity_mirror + '\'' +
                ", lighting_function='" + lighting_function + '\'' +
                ", rear_wiper='" + rear_wiper + '\'' +
                ", speed_sensing='" + speed_sensing + '\'' +
                ", rain_sensing='" + rain_sensing + '\'' +
                ", air_conditioner='" + air_conditioner + '\'' +
                ", automatic_air='" + automatic_air + '\'' +
                ", independent_air='" + independent_air + '\'' +
                ", air_outlet='" + air_outlet + '\'' +
                ", zoning_control='" + zoning_control + '\'' +
                ", filter_unit='" + filter_unit + '\'' +
                ", car_purifier='" + car_purifier + '\'' +
                ", fragrance_device='" + fragrance_device + '\'' +
                ", ion_generator='" + ion_generator + '\'' +
                ", car_refrigerator='" + car_refrigerator + '\'' +
                ", model_name='" + model_name + '\'' +
                ", car_series='" + car_series + '\'' +
                ", official_guidance='" + official_guidance + '\'' +
                ", car_power='" + car_power + '\'' +
                ", not_fastened='" + not_fastened + '\'' +
                ", fabric_seat='" + fabric_seat + '\'' +
                ", manual_folding='" + manual_folding + '\'' +
                ", manual_adjustment='" + manual_adjustment + '\'' +
                ", manual_anti='" + manual_anti + '\'' +
                ", spare_tire='" + spare_tire + '\'' +
                ", car_drive='" + car_drive + '\'' +
                ", front_row='" + front_row + '\'' +
                ", bone_Wiper='" + bone_Wiper + '\'' +
                ", rear_towbar='" + rear_towbar + '\'' +
                ", track_width='" + track_width + '\'' +
                ", leather_seat='" + leather_seat + '\'' +
                ", front_lamp='" + front_lamp + '\'' +
                ", halogen_headlamp='" + halogen_headlamp + '\'' +
                ", two_way_headrest='" + two_way_headrest + '\'' +
                ", tail_lamp='" + tail_lamp + '\'' +
                ", stop_lamp='" + stop_lamp + '\'' +
                ", front_headrest='" + front_headrest + '\'' +
                ", engine_power='" + engine_power + '\'' +
                ", car_tire='" + car_tire + '\'' +
                ", steel_rim='" + steel_rim + '\'' +
                ", usb='" + usb + '\'' +
                ", transmissions='" + transmissions + '\'' +
                ", car_name='" + car_name + '\'' +
                '}';
    }
}

