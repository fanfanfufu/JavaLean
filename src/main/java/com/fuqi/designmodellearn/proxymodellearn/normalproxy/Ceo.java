package com.fuqi.designmodellearn.proxymodellearn.normalproxy;

/**
 * @author FuQi
 * @date 2023/3/5 14:52
 * @description
 */
public class Ceo implements CeoOffice{
    private Ceo() {
    }

    @Override
    public Boolean talkAppointment(String visitor) {
        if ("family member".equals(visitor)) {
            System.out.println("CEO 今天只想与家人见面交谈。");
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public void releaseAnnouncement(int announceNum) {
        System.out.println("CEO签署发布第" + announceNum + "号声明。");
    }

    public static CeoAssistant getProxy() {
        Ceo ceo = new Ceo();
        return new CeoAssistant(ceo);
    }
}
