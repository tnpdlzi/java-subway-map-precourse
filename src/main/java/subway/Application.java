package subway;

import subway.domain.Line;
import subway.line.LineUtils;
import subway.line.SectionUtils;
import subway.station.StationUtils;
import subway.station.SubwayUtils;
import subway.validator.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        StationUtils stationUtils = new StationUtils(scanner);
        LineUtils lineUtils = new LineUtils(scanner);
        SectionUtils sectionUtils = new SectionUtils(scanner);
        SubwayUtils subwayUtils = new SubwayUtils();

        selectUtils(scanner, stationUtils, lineUtils, sectionUtils, subwayUtils);
    }

    public static void selectUtils(Scanner scanner, StationUtils stationUtils, LineUtils lineUtils, SectionUtils sectionUtils, SubwayUtils subwayUtils) {
        final int MAIN_QUIT = 0;

        while (true) {
            String chosen;
            int chosenNumber;

            System.out.println("## 메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료\n");
            System.out.println("## 원하는 기능을 선택하세요.");
            chosen = scanner.next();
            chosenNumber = Validator.isMainInputRight(chosen);
            if (chosenNumber == MAIN_QUIT) {
                break;
            }
            choose(chosenNumber, stationUtils, lineUtils, sectionUtils, subwayUtils);
        }
    }

    public static void choose(int chosenNumber, StationUtils stationUtils, LineUtils lineUtils, SectionUtils sectionUtils, SubwayUtils subwayUtils) {
        final int MAIN_STATION = 1;
        final int MAIN_LINE = 2;
        final int MAIN_SECTION = 3;
        final int MAIN_SUBWAY = 4;

        if (chosenNumber == MAIN_STATION) {
            stationUtils.play();
        }
        if (chosenNumber == MAIN_LINE) {
            lineUtils.play();
        }
        if (chosenNumber == MAIN_SECTION) {
            sectionUtils.play();
        }
        if (chosenNumber == MAIN_SUBWAY) {
            subwayUtils.play();
        }
    }
}
