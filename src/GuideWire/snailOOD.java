package GuideWire;

class snail {
    int day;
    int night;
    public snail(int day, int night) {
        this.day = day;
        this.night = night;
    }

    public int hmds(wall thisWall) {
        int s = 0;
        int res = 0;
        while(true) {
            s += day;
            res++;
            if (s >= thisWall.length) {
                break;
            }
            s -= night;
        }
        return res;
    }
}
class wall {
    int length;
    public wall(int length) {
        this.length = length;
    }
    public boolean check(int position) {
        if (position > length) {
            return true;
        } else {
            return false;
        }
    }
}

public class snailOOD {
    public static void main(String[] args) {
        snail s = new snail(5, 4);
        wall w = new wall(11);
        System.out.println(s.hmds(w));
    }
}
