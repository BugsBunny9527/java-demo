package com.java.test;

/**
 * Created by Luke Wang on 2018/9/6.
 * Java注释 测试类
 */
public class CommentsTest {
    /**
     * 测试【简述的结尾】.究竟是以中文句号为结束标志。还是以英文句号为结束标志标志.
     * <p>
     *     结果显示，是以中文句号为结束标志。
     * </p>
     */
    public int number01;

    /**
     * 测试【换行】。验证回
     * 车键能否在生成文档时<br>生效。
     * <p>
     *     结果显示，回车键不能在生成文档时生效，要想"换行"需要使用 HTML 标签。
     * </p>
     */
    public int number02;

    /**
     * 测试【标记】
     * @param name 名字
     * @return 返回"hello+[名字]"
     */
    public String test01(String name) {
        return "hello" + name;
    }

    /**
     * 测试【默认显示】，默认情况下，javadoc生成的文档只会显示protected/public 类和成员(属性、方法)。
     */
    public String publicString;
    protected String protectedString;
    String defaultString;
    private String privateString;

    public void test02(){}
    protected void test03(){}
    void test04(){}
    private void test05(){}
}
