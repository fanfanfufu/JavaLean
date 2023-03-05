package com.fuqi.designmodellearn.proxymodellearn.normalproxy;

/**
 * @author FuQi
 * @date 2023/3/5 15:08
 * @description
 */
public class NormalProxyText {
    public static void main(String[] args) {
        // 通过真实对象类提供的获取代理对象的方法，得到代理对象
        // 无法直接得到真实对象，从而对真实对象起到了隔离保护的作用
        CeoAssistant ceoAssistant = Ceo.getProxy();
        ceoAssistant.talkAppointment("陌生人");
        ceoAssistant.talkAppointment("family member");
        ceoAssistant.releaseAnnouncement(1);
        ceoAssistant.releaseAnnouncement(2);
    }
}
