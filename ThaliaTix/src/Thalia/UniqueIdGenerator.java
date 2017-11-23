package Thalia;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
    static AtomicInteger atomicIntegerShows = new AtomicInteger();
    static AtomicInteger atomicIntegerOrders = new AtomicInteger();
    static AtomicInteger atomicIntegerTickets = new AtomicInteger();
    static AtomicInteger atomicIntegerDonations = new AtomicInteger();

    
    public static int getUniqueShowID() {
        return atomicIntegerShows.incrementAndGet();
    }
    
    public static int getUniqueOrderID() {
        return atomicIntegerOrders.incrementAndGet();
    }
    
    public static int getUniqueTicketID() {
        return atomicIntegerTickets.incrementAndGet();
    }
    
    public static int getUniqueDonationID() {
        return atomicIntegerDonations.incrementAndGet();
    }
}
