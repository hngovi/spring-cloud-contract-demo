package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("triggerMessage")
    input {
        triggeredBy("triggerMessage()")
    }
    outputMessage {
        sentTo("inquiry-input")
        body(file("inquiryForUpdate.json"))
    }
}
