package subway.validator;

import subway.domain.StationRepository;

public class Validator {
    private static final String UNABLE_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String ALREADY_EXIST_STATION = "[ERROR] 이미 등록된 역 이름입니다.";
    private static final int MIN_STATION_AND_LINE_NUMBER = 1;
    private static final int MAX_STATION_AND_LINE_NUMBER = 3;
    private static final int MIN_MAIN_NUMBER = 1;
    private static final int MAX_MAIN_NUMBER = 4;
    private static final int MIN_SECTION_NUMBER = 1;
    private static final int MAX_SECTION_NUMBER = 2;
    private static final int BACK_NUMBER = 0;
    private static final int QUIT_NUMBER = 0;



    public Validator() {
    }

    public static int isInputRight(String number) {
        int integerNumber;

        if (number.equals("B")) {
            return BACK_NUMBER;
        }

        try {
            integerNumber = Integer.parseInt(number);
            if (!(integerNumber >= MIN_STATION_AND_LINE_NUMBER && integerNumber <= MAX_STATION_AND_LINE_NUMBER)) {
                throw new IllegalArgumentException(UNABLE_INPUT);
            }
            return integerNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(UNABLE_INPUT);
        }
    }

    public static int isSectionInputRight(String number) {
        int integerNumber;

        if (number.equals("B")) {
            return BACK_NUMBER;
        }

        try {
            integerNumber = Integer.parseInt(number);
            if (!(integerNumber >= MIN_SECTION_NUMBER && integerNumber <= MAX_SECTION_NUMBER)) {
                throw new IllegalArgumentException(UNABLE_INPUT);
            }
            return integerNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(UNABLE_INPUT);
        }
    }

    public static int isMainInputRight(String number) {
        int integerNumber;

        if (number.equals("Q")) {
            return QUIT_NUMBER;
        }

        try {
            integerNumber = Integer.parseInt(number);
            if (!(integerNumber >= MIN_MAIN_NUMBER && integerNumber <= MAX_MAIN_NUMBER)) {
                throw new IllegalArgumentException(UNABLE_INPUT);
            }
            return integerNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(UNABLE_INPUT);
        }
    }

    public static void isStationAlreadyExist(String name) {
        if (StationRepository.getStationByName(name) != null) {
            throw new IllegalArgumentException(ALREADY_EXIST_STATION);
        }

    }
}
