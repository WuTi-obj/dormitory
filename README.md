# dormitory
技术栈：Spring Boot+Mybatis-plus+Vue2+Element-UI

主要功能：
本项目分为管理员和宿舍管理员两个模块，通过不同的账号密码进入不同的模块。管理员具有宿管管理、学生管理、楼宇管理、宿舍管理等模块与学生迁入迁出以及缺寝查询等功能，数据展示实现分页、模糊查询等功能。宿舍管理员能处理学生缺寝登记与缺寝查询功能，数据展示实现分页。 

个人职责：
1.MySQL数据库设计：楼宇表，宿管表，宿舍表，管理员表，学生表，请假表，迁出学生表；
2.功能设计：宿管、学生、楼宇、宿舍、学生迁入迁出、学生缺寝管理功能；
3.工具类设计：常用工具CommonUtil类、VO结果工具ResultVOUtil、VO转换工具VOChangeUtil；
4.Controller类设计：SystemAdminController类、BuildingController类、DormitoryController类等；
5.其他类：entity实体类设计、实体VO类设计、service类设计、service实现impl类、Mapping类；

难点：
1.实体类和VO的转换：在处理查询功能和列表功能时，需要将实体中记录的某_id转换成某_name，如查询学生信息时将查询到的dormitory_id转dormitory_name处理；
2.级联：由于楼宇包含宿舍，宿舍包含学生，操作父子级时需要联动；

解决：
1.VO转换问题：
思路：在实体VO类中添加某Name属性，将获取到的实体类数据赋值给对应VO类在set某Name的值，循环该过程存入List表中；
方案：对所有需要转换的类型设计相应的VO，通过循环BeanUtils.copyProperties(Object source, Object target);方法保存到相应List表中实现对应表数据的VO转换；
实现：在查询和列表功能中，如学生列表的查询和展示功能显示宿舍的name而不是宿舍id；
2.级联问题：
思路：先找到父类的所有一级子类放到List列表中，在找每个子类的下一级子类放入List表中；
方案：使用QueryWrapper对象调用Children like(R column, Object val);方法查询子类，for循环储存到子类List表中；
实现：在宿舍管理员的缺寝登记功能中，选择楼宇后子级列表会更新为该楼宇下的宿舍，在选择宿舍后子集列表只会显示该宿舍内的“入住”的同学；
在删除楼宇功能中，先查出该楼内所有宿舍以及对应宿舍状态“入住”的学生，给学生换宿舍后，再删除宿舍、删除楼宇；

管理员账号密码：

admin1     123123

admin2     123123

admin3     123123



宿舍管理员账号密码：

ll   123123

ww   123123

zz   123123

xm   123123
