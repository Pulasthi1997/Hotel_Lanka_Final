package com.example.hotel;

    public class Feedback {
        String Hotel;
        String Satist;
        String Note;

        public Feedback() {
        }

        public Feedback(String hotel, String satist, String note) {
            Hotel = hotel;
            Satist = satist;
            Note = note;
        }

        public String getHotel() {
            return Hotel;
        }

        public void setHotel(String hotel) {
            Hotel = hotel;
        }

        public String getSatist() {
            return Satist;
        }

        public void setSatist(String satist) {
            Satist = satist;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String note) {
            Note = note;
        }
    }
