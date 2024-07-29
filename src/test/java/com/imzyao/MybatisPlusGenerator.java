package com.imzyao;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class MybatisPlusGenerator {

    private static final String DIR = System.getProperty("user.dir") + "/generate-code";
    private static final String AUTHOR = "imzyao";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "root1234";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/my-database";
    private static final String PACKAGE_NAME = "com.imzyao";
    private static final String MODULE_NAME = "";


    @Test
    public void generatorTest(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USER_NAME, PASS_WORD)
                .globalConfig(builder -> {
                    /**
                     * 设置作者
                     */
                    builder.author(AUTHOR)
                            /**
                             * 开启 swagger 模式
                             */
                            .enableSwagger()
                            /**
                             * 覆盖已生成文件
                             */
                            .fileOverride()
                            /**
                             * 禁止打开输出目录
                             */
                            .disableOpenDir()
                            /**
                             * 指定输出目录
                             */
                            .outputDir(DIR);
                })
                .packageConfig(builder -> {
                    /**
                     * 设置父包名
                     */
                    builder.parent(PACKAGE_NAME)
                            /**
                             * 设置父包模块名
                             */
                            .moduleName(MODULE_NAME)
                            .entity("modules.entity")
                            .mapper("mappers")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            /**
                             * 设置mapperXml生成路径
                             */
                            .pathInfo(Collections.singletonMap(OutputFile.xml, DIR)); //
                })
                .strategyConfig(builder -> {
                    /**
                     * 设置需要生成的表名
                     */
                    builder.addInclude()
                            /**
                             * 设置过滤表前缀
                             */
                            .addTablePrefix();
                })
                /**
                 * 使用Freemarker引擎模板，默认的是Velocity引擎模板
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}