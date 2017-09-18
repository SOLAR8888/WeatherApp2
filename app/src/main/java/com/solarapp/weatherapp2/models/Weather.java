package com.solarapp.weatherapp2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vereskun on 16.09.2017.
 */

public class Weather {
    @SerializedName("Headline")
    @Expose
    private Headline headline;

    @SerializedName("DailyForecasts")
    @Expose
    private DailyForecast[] dailyForecasts;

    public DailyForecast[] getDailyForecasts() {
        return dailyForecasts;
    }

    class Headline{
        @SerializedName("EffectiveDate")
        @Expose
        private String effectiveDate;

        @SerializedName("EffectiveEpochDate")
        @Expose
        private long effectiveEpochDate;

        @SerializedName("Severity")
        @Expose
        private int severity;

        @SerializedName("Text")
        @Expose
        private String text;

        @SerializedName("Category")
        @Expose
        private String category;

        @SerializedName("EndDate")
        @Expose
        private String endDate;

        @SerializedName("EndEpochDate")
        @Expose
        private long endEpochDate;

        @SerializedName("MobileLink")
        @Expose
        private String mobileLink;

        @SerializedName("Link")
        @Expose
        private String link;

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public long getEffectiveEpochDate() {
            return effectiveEpochDate;
        }

        public void setEffectiveEpochDate(long effectiveEpochDate) {
            this.effectiveEpochDate = effectiveEpochDate;
        }

        public int getSeverity() {
            return severity;
        }

        public void setSeverity(int severity) {
            this.severity = severity;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public long getEndEpochDate() {
            return endEpochDate;
        }

        public void setEndEpochDate(long endEpochDate) {
            this.endEpochDate = endEpochDate;
        }

        public String getMobileLink() {
            return mobileLink;
        }

        public void setMobileLink(String mobileLink) {
            this.mobileLink = mobileLink;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
    public  class DailyForecast {
        @SerializedName("Date")
        @Expose
        private String date;

        @SerializedName("EpochDate")
        @Expose
        private long epochDate;

        @SerializedName("Temperature")
        @Expose
        private Temperature temperature;

        public class Temperature {
            @SerializedName("Minimum")
            @Expose
            private Minimum minimum;

            public class Minimum {
                @SerializedName("Value")
                @Expose
                private float value;

                @SerializedName("Unit")
                @Expose
                private String unit;

                @SerializedName("UnitType")
                @Expose
                private int unitType;

                public float getValue() {
                    return value;
                }

                public void setValue(float value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public int getUnitType() {
                    return unitType;
                }

                public void setUnitType(int unitType) {
                    this.unitType = unitType;
                }
            }

            @SerializedName("Maximum")
            @Expose
            private Maximum maximum;

            public class Maximum {
                @SerializedName("Value")
                @Expose
                private float value;

                @SerializedName("Unit")
                @Expose
                private String unit;

                @SerializedName("UnitType")
                @Expose
                private int unitType;

                public float getValue() {
                    return value;
                }

                public void setValue(float value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public int getUnitType() {
                    return unitType;
                }

                public void setUnitType(int unitType) {
                    this.unitType = unitType;
                }
            }

            public Minimum getMinimum() {
                return minimum;
            }

            public void setMinimum(Minimum minimum) {
                this.minimum = minimum;
            }

            public Maximum getMaximum() {
                return maximum;
            }

            public void setMaximum(Maximum maximum) {
                this.maximum = maximum;
            }
        }

        @SerializedName("Day")
        @Expose
        private Day day;

        public class Day {
            @SerializedName("Icon")
            @Expose
            private int icon;

            @SerializedName("IconPhrase")
            @Expose
            private String iconPhrase;

            public int getIcon() {
                return icon;
            }

            public void setIcon(int icon) {
                this.icon = icon;
            }

            public String getIconPhrase() {
                return iconPhrase;
            }

            public void setIconPhrase(String iconPhrase) {
                this.iconPhrase = iconPhrase;
            }
        }

        @SerializedName("Night")
        @Expose
        private Night night;

        public class Night {
            @SerializedName("Icon")
            @Expose
            private int icon;

            @SerializedName("IconPhrase")
            @Expose
            private String iconPhrase;

            public int getIcon() {
                return icon;
            }

            public void setIcon(int icon) {
                this.icon = icon;
            }

            public String getIconPhrase() {
                return iconPhrase;
            }

            public void setIconPhrase(String iconPhrase) {
                this.iconPhrase = iconPhrase;
            }
        }

        @SerializedName("Sources")
        @Expose
        private String[] sources;

        @SerializedName("MobileLink")
        @Expose
        private String mobileLink;

        @SerializedName("Link")
        @Expose
        private String link;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public long getEpochDate() {
            return epochDate;
        }

        public void setEpochDate(long epochDate) {
            this.epochDate = epochDate;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Night getNight() {
            return night;
        }

        public void setNight(Night night) {
            this.night = night;
        }

        public String[] getSources() {
            return sources;
        }

        public void setSources(String[] sources) {
            this.sources = sources;
        }

        public String getMobileLink() {
            return mobileLink;
        }

        public void setMobileLink(String mobileLink) {
            this.mobileLink = mobileLink;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
