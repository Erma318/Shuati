package f5tech;

public class q3 {
    static boolean isIPInRange(String range, String ipAddress) {
        //Assumption: all digit in range and ipAddress are valid number
        String[] arr = range.split("\\.");
        String[] ip = ipAddress.split("\\.");
        if (arr.length != 4 || ip.length != 4) //if the length of range array or ip array is not 4, it means invalid ip address format, return false
            return false;
        if (!(arr[arr.length - 1].equals("0"))) // if the last position of range is not 0, it is not a valid range, return false
            return false;
        int start = 0;
        for (int i = 0; i < arr.length; i++) { // 1. find the start index of 0 in range
            if (arr[i].equals("0")) {
                start = i;
                break;
            }
        }
        for (int i = 0; i < start; i++) { // 2. if the digits before 0 is not same, it's impossible that ip address is in range
            if (!ip[i].equals(arr[i]))
                return false;
        }
        for (int i = start; i < ip.length; i++) { // 3. if the ipaddress is less than 0 or larger than 255, it's invalid ip address, return false
            if (Integer.valueOf(ip[i]) < 0 || Integer.valueOf(ip[i]) > 255)
                return false;
        }
        return true;
    }
// time complexity is O(n);
// space complexity is O(n);
}
