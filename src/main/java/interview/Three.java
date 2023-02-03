package interview;

/**
 * @author Ikechi Ucheagwu
 * @created 02/02/2023 - 22:19
 * @project Algo Github
 */

public class Three {

    public static void main(String[] args) {
        int[] particles = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}; //-> 5
        int[] particles1 = {1, 3, 5, 7, 9}; //-> 6
        int[] particles2 = {7, 7, 7, 7}; //-> 3
        System.out.println(particleVelocity(particles));
        System.out.println(particleVelocity(particles1));
        System.out.println(particleVelocity(particles2));
    }

    private static int particleVelocity(int[] particles) {
        int result = 0;
        for (int i = 0; i < particles.length; i++) {
            for (int count = 0; i + 2 < particles.length && particles[i + 1] - particles[i] == particles[i + 2] - particles[i + 1]; i++) {
                count++;
                result += count;
            }
        }

        return result < 1000000000 ? result : -1;
    }
}
