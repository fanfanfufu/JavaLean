package com.fuqi.designmodellearn.proxymodellearn.normalproxy;

/**
 * @author FuQi
 * @date 2023/3/5 15:08
 * @description
 */
public class NormalProxyText {
    public static void main(String[] args) {
        CeoAssistant ceoAssistant = Ceo.getProxy();
        ceoAssistant.talkAppointment("陌生人");
        ceoAssistant.talkAppointment("family member");
        ceoAssistant.releaseAnnouncement(1);
        ceoAssistant.releaseAnnouncement(2);
    }
}
