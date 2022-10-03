package edu.kmaooad;




/*{
        "update_id":734202944,
        "message":{
        "message_id":2,
        "from":{"id":691323674,
                "is_bot":false,
                "first_name":"\u2642Vladdik",
                "last_name":"Kiddalv\u2642",
                "username":"kovrud",
                "language_code":"uk"
                },
        "chat":{
                "id":691323674,
                "first_name":"\u2642Vladdik",
                "last_name":"Kiddalv\u2642",
                "username":"kovrud",
                "type":"private"
        },
        "date":1664829057,
        "text":"/start",
        "entities":[{"offset":0,"length":6,"type":"bot_command"}]
        }
}*/


public class Message {
    private Long update_id;
    private MessageInside message;

    public Long getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(Long update_id) {
        this.update_id = update_id;
    }

    public MessageInside getMessage() {
        return message;
    }

    public void setMessage(MessageInside message) {
        this.message = message;
    }


    static class MessageInside {
        private Long message_id;

        public Long getMessage_id() {
            return message_id;
        }

        public void setMessage_id(Long message_id) {
            this.message_id = message_id;
        }
    }
}
