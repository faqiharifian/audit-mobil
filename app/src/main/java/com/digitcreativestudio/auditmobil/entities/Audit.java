package com.digitcreativestudio.auditmobil.entities;

import java.io.Serializable;

/**
 * Created by faqih on 19/05/17.
 */

public class Audit implements Serializable{
    String id;

    boolean instantiated0 = false;
    boolean stnk_check;
    String stnk_valid_date;
    String stnk_information;
    String stnk_image_name;
    String stnk_image;
    boolean llajr_check;
    String llajr_valid_date;
    String llajr_information;
    String llajr_image_name;
    String llajr_image;


    boolean instantiated1 = false;
    boolean safety_switch_1_check;
    String safety_switch_1_information;
    String safety_switch_1_image_name;
    String safety_switch_1_image;
    boolean safety_switch_2_check;
    String safety_switch_2_information;
    String safety_switch_2_image_name;
    String safety_switch_2_image;
    boolean starter_check;
    String starter_information;
    String starter_image_name;
    String starter_image;


    boolean instantiated2 = false;
    boolean bent_check;
    String bent_information;
    String bent_image_name;
    String bent_image;
    boolean standard_check;
    String standard_emission;
    String standard_information;
    String standard_image_name;
    String standard_image;


    boolean instantiated3 = false;
    boolean isolated_check;
    String isolated_information;
    String isolated_image_name;
    String isolated_image;
    boolean fuse_original_check;
    String fuse_original_information;
    String fuse_original_image_name;
    String fuse_original_image;


    boolean instantiated4 = false;
    boolean well_maintained_check;
    String well_maintained_information;
    String well_maintained_image_name;
    String well_maintained_image;
    boolean well_installed_check;
    String well_installed_information;
    String well_installed_image_name;
    String well_installed_image;


    boolean instantiated5 = false;
    boolean light_on_closed_check;
    String light_on_closed_information;
    String light_on_closed_image_name;
    String light_on_closed_image;
    boolean light_overall_check;
    String light_overall_information;
    String light_overall_image_name;
    String light_overall_image;


    boolean instantiated6 = false;
    boolean nonporous_has_logo_check;
    String nonporous_has_logo_information;
    String nonporous_has_logo_image_name;
    String nonporous_has_logo_image;
    boolean clear_writing_check;
    String clear_writing_information;
    String clear_writing_image_name;
    String clear_writing_image;
    boolean wood_coated_check;
    String wood_coated_information;
    String wood_coated_image_name;
    String wood_coated_image;


    boolean instantiated7 = false;
    boolean dcp_co2_check;
    String dcp_co2_information;
    String dcp_co2_image_name;
    String dcp_co2_image;
    boolean good_condition_check;
    String good_condition_information;
    String good_condition_image_name;
    String good_condition_image;


    boolean instantiated8 = false;
    boolean working_check;
    String working_information;
    String working_image_name;
    String working_image;


    boolean instantiated9 = false;
    boolean front_tire_check;
    String front_tire_information;
    String front_tire_image_name;
    String front_tire_image;
    boolean rear_tire_check;
    String rear_tire_information;
    String rear_tire_image_name;
    String rear_tire_image;


    boolean instantiated10 = false;
    boolean steer_max_check;
    String steer_max_information;
    String steer_max_image_name;
    String steer_max_image;
    boolean easy_steer_check;
    String easy_steer_information;
    String easy_steer_image_name;
    String easy_steer_image;


    boolean instantiated11 = false;
    boolean overall_check;
    String overall_information;
    String overall_image_name;
    String overall_image;


    boolean instantiated12 = false;
    boolean emergency_check;
    String emergency_information;
    String emergency_image_name;
    String emergency_image;
    boolean door_check;
    String door_information;
    String door_image_name;
    String door_image;
    boolean spatbor_check;
    String spatbor_information;
    String spatbor_image_name;
    String spatbor_image;

    public void setId(String id) {
        this.id = id;
    }

    public void setStnk_check(boolean stnk_check) {
        this.stnk_check = stnk_check;
    }

    public void setStnk_valid_date(String stnk_valid_date) {
        this.stnk_valid_date = stnk_valid_date;
    }

    public void setStnk_information(String stnk_information) {
        this.stnk_information = stnk_information;
    }

    public void setStnk_image_name(String stnk_image_name) {
        this.stnk_image_name = stnk_image_name;
    }

    public void setStnk_image(String stnk_image) {
        this.stnk_image = stnk_image;
    }

    public void setLlajr_check(boolean llajr_check) {
        this.llajr_check = llajr_check;
    }

    public void setLlajr_valid_date(String llajr_valid_date) {
        this.llajr_valid_date = llajr_valid_date;
    }

    public void setLlajr_information(String llajr_information) {
        this.llajr_information = llajr_information;
    }

    public void setLlajr_image_name(String llajr_image_name) {
        this.llajr_image_name = llajr_image_name;
    }

    public void setLlajr_image(String llajr_image) {
        this.llajr_image = llajr_image;
    }

    public void setSafety_switch_1_check(boolean safety_switch_1_check) {
        this.safety_switch_1_check = safety_switch_1_check;
    }

    public void setSafety_switch_1_information(String safety_switch_1_information) {
        this.safety_switch_1_information = safety_switch_1_information;
    }

    public void setSafety_switch_1_image_name(String safety_switch_1_image_name) {
        this.safety_switch_1_image_name = safety_switch_1_image_name;
    }

    public void setSafety_switch_1_image(String safety_switch_1_image) {
        this.safety_switch_1_image = safety_switch_1_image;
    }

    public void setSafety_switch_2_check(boolean safety_switch_2_check) {
        this.safety_switch_2_check = safety_switch_2_check;
    }

    public void setSafety_switch_2_information(String safety_switch_2_information) {
        this.safety_switch_2_information = safety_switch_2_information;
    }

    public void setSafety_switch_2_image_name(String safety_switch_2_image_name) {
        this.safety_switch_2_image_name = safety_switch_2_image_name;
    }

    public void setSafety_switch_2_image(String safety_switch_2_image) {
        this.safety_switch_2_image = safety_switch_2_image;
    }

    public void setStarter_check(boolean starter_check) {
        this.starter_check = starter_check;
    }

    public void setStarter_information(String starter_information) {
        this.starter_information = starter_information;
    }

    public void setStarter_image_name(String starter_image_name) {
        this.starter_image_name = starter_image_name;
    }

    public void setStarter_image(String starter_image) {
        this.starter_image = starter_image;
    }

    public void setBent_check(boolean bent_check) {
        this.bent_check = bent_check;
    }

    public void setBent_information(String bent_information) {
        this.bent_information = bent_information;
    }

    public void setBent_image_name(String bent_image_name) {
        this.bent_image_name = bent_image_name;
    }

    public void setBent_image(String bent_image) {
        this.bent_image = bent_image;
    }

    public void setStandard_check(boolean standard_check) {
        this.standard_check = standard_check;
    }

    public void setStandard_emission(String standard_emission) {
        this.standard_emission = standard_emission;
    }

    public void setStandard_information(String standard_information) {
        this.standard_information = standard_information;
    }

    public void setStandard_image_name(String standard_image_name) {
        this.standard_image_name = standard_image_name;
    }

    public void setStandard_image(String standard_image) {
        this.standard_image = standard_image;
    }

    public void setIsolated_check(boolean isolated_check) {
        this.isolated_check = isolated_check;
    }

    public void setIsolated_information(String isolated_information) {
        this.isolated_information = isolated_information;
    }

    public void setIsolated_image_name(String isolated_image_name) {
        this.isolated_image_name = isolated_image_name;
    }

    public void setIsolated_image(String isolated_image) {
        this.isolated_image = isolated_image;
    }

    public void setFuse_original_check(boolean fuse_original_check) {
        this.fuse_original_check = fuse_original_check;
    }

    public void setFuse_original_information(String fuse_original_information) {
        this.fuse_original_information = fuse_original_information;
    }

    public void setFuse_original_image_name(String fuse_original_image_name) {
        this.fuse_original_image_name = fuse_original_image_name;
    }

    public void setFuse_original_image(String fuse_original_image) {
        this.fuse_original_image = fuse_original_image;
    }

    public void setWell_maintained_check(boolean well_maintained_check) {
        this.well_maintained_check = well_maintained_check;
    }

    public void setWell_maintained_information(String well_maintained_information) {
        this.well_maintained_information = well_maintained_information;
    }

    public void setWell_maintained_image_name(String well_maintained_image_name) {
        this.well_maintained_image_name = well_maintained_image_name;
    }

    public void setWell_maintained_image(String well_maintained_image) {
        this.well_maintained_image = well_maintained_image;
    }

    public void setWell_installed_check(boolean well_installed_check) {
        this.well_installed_check = well_installed_check;
    }

    public void setWell_installed_information(String well_installed_information) {
        this.well_installed_information = well_installed_information;
    }

    public void setWell_installed_image_name(String well_installed_image_name) {
        this.well_installed_image_name = well_installed_image_name;
    }

    public void setWell_installed_image(String well_installed_image) {
        this.well_installed_image = well_installed_image;
    }

    public void setLight_on_closed_check(boolean light_on_closed_check) {
        this.light_on_closed_check = light_on_closed_check;
    }

    public void setLight_on_closed_information(String light_on_closed_information) {
        this.light_on_closed_information = light_on_closed_information;
    }

    public void setLight_on_closed_image_name(String light_on_closed_image_name) {
        this.light_on_closed_image_name = light_on_closed_image_name;
    }

    public void setLight_on_closed_image(String light_on_closed_image) {
        this.light_on_closed_image = light_on_closed_image;
    }

    public void setLight_overall_check(boolean light_overall_check) {
        this.light_overall_check = light_overall_check;
    }

    public void setLight_overall_information(String light_overall_information) {
        this.light_overall_information = light_overall_information;
    }

    public void setLight_overall_image_name(String light_overall_image_name) {
        this.light_overall_image_name = light_overall_image_name;
    }

    public void setLight_overall_image(String light_overall_image) {
        this.light_overall_image = light_overall_image;
    }

    public void setNonporous_has_logo_check(boolean nonporous_has_logo_check) {
        this.nonporous_has_logo_check = nonporous_has_logo_check;
    }

    public void setNonporous_has_logo_information(String nonporous_has_logo_information) {
        this.nonporous_has_logo_information = nonporous_has_logo_information;
    }

    public void setNonporous_has_logo_image_name(String nonporous_has_logo_image_name) {
        this.nonporous_has_logo_image_name = nonporous_has_logo_image_name;
    }

    public void setNonporous_has_logo_image(String nonporous_has_logo_image) {
        this.nonporous_has_logo_image = nonporous_has_logo_image;
    }

    public void setClear_writing_check(boolean clear_writing_check) {
        this.clear_writing_check = clear_writing_check;
    }

    public void setClear_writing_information(String clear_writing_information) {
        this.clear_writing_information = clear_writing_information;
    }

    public void setClear_writing_image_name(String clear_writing_image_name) {
        this.clear_writing_image_name = clear_writing_image_name;
    }

    public void setClear_writing_image(String clear_writing_image) {
        this.clear_writing_image = clear_writing_image;
    }

    public void setWood_coated_check(boolean wood_coated_check) {
        this.wood_coated_check = wood_coated_check;
    }

    public void setWood_coated_information(String wood_coated_information) {
        this.wood_coated_information = wood_coated_information;
    }

    public void setWood_coated_image_name(String wood_coated_image_name) {
        this.wood_coated_image_name = wood_coated_image_name;
    }

    public void setWood_coated_image(String wood_coated_image) {
        this.wood_coated_image = wood_coated_image;
    }

    public void setDcp_co2_check(boolean dcp_co2_check) {
        this.dcp_co2_check = dcp_co2_check;
    }

    public void setDcp_co2_information(String dcp_co2_information) {
        this.dcp_co2_information = dcp_co2_information;
    }

    public void setDcp_co2_image_name(String dcp_co2_image_name) {
        this.dcp_co2_image_name = dcp_co2_image_name;
    }

    public void setDcp_co2_image(String dcp_co2_image) {
        this.dcp_co2_image = dcp_co2_image;
    }

    public void setGood_condition_check(boolean good_condition_check) {
        this.good_condition_check = good_condition_check;
    }

    public void setGood_condition_information(String good_condition_information) {
        this.good_condition_information = good_condition_information;
    }

    public void setGood_condition_image_name(String good_condition_image_name) {
        this.good_condition_image_name = good_condition_image_name;
    }

    public void setGood_condition_image(String good_condition_image) {
        this.good_condition_image = good_condition_image;
    }

    public void setWorking_check(boolean working_check) {
        this.working_check = working_check;
    }

    public void setWorking_information(String working_information) {
        this.working_information = working_information;
    }

    public void setWorking_image_name(String working_image_name) {
        this.working_image_name = working_image_name;
    }

    public void setWorking_image(String working_image) {
        this.working_image = working_image;
    }

    public void setFront_tire_check(boolean front_tire_check) {
        this.front_tire_check = front_tire_check;
    }

    public void setFront_tire_information(String front_tire_information) {
        this.front_tire_information = front_tire_information;
    }

    public void setFront_tire_image_name(String front_tire_image_name) {
        this.front_tire_image_name = front_tire_image_name;
    }

    public void setFront_tire_image(String front_tire_image) {
        this.front_tire_image = front_tire_image;
    }

    public void setRear_tire_check(boolean rear_tire_check) {
        this.rear_tire_check = rear_tire_check;
    }

    public void setRear_tire_information(String rear_tire_information) {
        this.rear_tire_information = rear_tire_information;
    }

    public void setRear_tire_image_name(String rear_tire_image_name) {
        this.rear_tire_image_name = rear_tire_image_name;
    }

    public void setRear_tire_image(String rear_tire_image) {
        this.rear_tire_image = rear_tire_image;
    }

    public void setSteer_max_check(boolean steer_max_check) {
        this.steer_max_check = steer_max_check;
    }

    public void setSteer_max_information(String steer_max_information) {
        this.steer_max_information = steer_max_information;
    }

    public void setSteer_max_image_name(String steer_max_image_name) {
        this.steer_max_image_name = steer_max_image_name;
    }

    public void setSteer_max_image(String steer_max_image) {
        this.steer_max_image = steer_max_image;
    }

    public void setEasy_steer_check(boolean easy_steer_check) {
        this.easy_steer_check = easy_steer_check;
    }

    public void setEasy_steer_information(String easy_steer_information) {
        this.easy_steer_information = easy_steer_information;
    }

    public void setEasy_steer_image_name(String easy_steer_image_name) {
        this.easy_steer_image_name = easy_steer_image_name;
    }

    public void setEasy_steer_image(String easy_steer_image) {
        this.easy_steer_image = easy_steer_image;
    }

    public void setOverall_check(boolean overall_check) {
        this.overall_check = overall_check;
    }

    public void setOverall_information(String overall_information) {
        this.overall_information = overall_information;
    }

    public void setOverall_image_name(String overall_image_name) {
        this.overall_image_name = overall_image_name;
    }

    public void setOverall_image(String overall_image) {
        this.overall_image = overall_image;
    }

    public void setEmergency_check(boolean emergency_check) {
        this.emergency_check = emergency_check;
    }

    public void setEmergency_information(String emergency_information) {
        this.emergency_information = emergency_information;
    }

    public void setEmergency_image_name(String emergency_image_name) {
        this.emergency_image_name = emergency_image_name;
    }

    public void setEmergency_image(String emergency_image) {
        this.emergency_image = emergency_image;
    }

    public void setDoor_check(boolean door_check) {
        this.door_check = door_check;
    }

    public void setDoor_information(String door_information) {
        this.door_information = door_information;
    }

    public void setDoor_image_name(String door_image_name) {
        this.door_image_name = door_image_name;
    }

    public void setDoor_image(String door_image) {
        this.door_image = door_image;
    }

    public void setSpatbor_check(boolean spatbor_check) {
        this.spatbor_check = spatbor_check;
    }

    public void setSpatbor_information(String spatbor_information) {
        this.spatbor_information = spatbor_information;
    }

    public void setSpatbor_image_name(String spatbor_image_name) {
        this.spatbor_image_name = spatbor_image_name;
    }

    public void setSpatbor_image(String spatbor_image) {
        this.spatbor_image = spatbor_image;
    }

    public String getId() {
        return id;
    }

    public boolean isStnk_check() {
        return stnk_check;
    }

    public String getStnk_valid_date() {
        return stnk_valid_date;
    }

    public String getStnk_information() {
        return stnk_information;
    }

    public String getStnk_image_name() {
        return stnk_image_name;
    }

    public String getStnk_image() {
        return stnk_image;
    }

    public boolean isLlajr_check() {
        return llajr_check;
    }

    public String getLlajr_valid_date() {
        return llajr_valid_date;
    }

    public String getLlajr_information() {
        return llajr_information;
    }

    public String getLlajr_image_name() {
        return llajr_image_name;
    }

    public String getLlajr_image() {
        return llajr_image;
    }

    public boolean isSafety_switch_1_check() {
        return safety_switch_1_check;
    }

    public String getSafety_switch_1_information() {
        return safety_switch_1_information;
    }

    public String getSafety_switch_1_image_name() {
        return safety_switch_1_image_name;
    }

    public String getSafety_switch_1_image() {
        return safety_switch_1_image;
    }

    public boolean isSafety_switch_2_check() {
        return safety_switch_2_check;
    }

    public String getSafety_switch_2_information() {
        return safety_switch_2_information;
    }

    public String getSafety_switch_2_image_name() {
        return safety_switch_2_image_name;
    }

    public String getSafety_switch_2_image() {
        return safety_switch_2_image;
    }

    public boolean isStarter_check() {
        return starter_check;
    }

    public String getStarter_information() {
        return starter_information;
    }

    public String getStarter_image_name() {
        return starter_image_name;
    }

    public String getStarter_image() {
        return starter_image;
    }

    public boolean isBent_check() {
        return bent_check;
    }

    public String getBent_information() {
        return bent_information;
    }

    public String getBent_image_name() {
        return bent_image_name;
    }

    public String getBent_image() {
        return bent_image;
    }

    public boolean isStandard_check() {
        return standard_check;
    }

    public String getStandard_emission() {
        return standard_emission;
    }

    public String getStandard_information() {
        return standard_information;
    }

    public String getStandard_image_name() {
        return standard_image_name;
    }

    public String getStandard_image() {
        return standard_image;
    }

    public boolean isolated_check() {
        return isolated_check;
    }

    public String getIsolated_information() {
        return isolated_information;
    }

    public String getIsolated_image_name() {
        return isolated_image_name;
    }

    public String getIsolated_image() {
        return isolated_image;
    }

    public boolean isFuse_original_check() {
        return fuse_original_check;
    }

    public String getFuse_original_information() {
        return fuse_original_information;
    }

    public String getFuse_original_image_name() {
        return fuse_original_image_name;
    }

    public String getFuse_original_image() {
        return fuse_original_image;
    }

    public boolean isWell_maintained_check() {
        return well_maintained_check;
    }

    public String getWell_maintained_information() {
        return well_maintained_information;
    }

    public String getWell_maintained_image_name() {
        return well_maintained_image_name;
    }

    public String getWell_maintained_image() {
        return well_maintained_image;
    }

    public boolean isWell_installed_check() {
        return well_installed_check;
    }

    public String getWell_installed_information() {
        return well_installed_information;
    }

    public String getWell_installed_image_name() {
        return well_installed_image_name;
    }

    public String getWell_installed_image() {
        return well_installed_image;
    }

    public boolean isLight_on_closed_check() {
        return light_on_closed_check;
    }

    public String getLight_on_closed_information() {
        return light_on_closed_information;
    }

    public String getLight_on_closed_image_name() {
        return light_on_closed_image_name;
    }

    public String getLight_on_closed_image() {
        return light_on_closed_image;
    }

    public boolean isLight_overall_check() {
        return light_overall_check;
    }

    public String getLight_overall_information() {
        return light_overall_information;
    }

    public String getLight_overall_image_name() {
        return light_overall_image_name;
    }

    public String getLight_overall_image() {
        return light_overall_image;
    }

    public boolean isNonporous_has_logo_check() {
        return nonporous_has_logo_check;
    }

    public String getNonporous_has_logo_information() {
        return nonporous_has_logo_information;
    }

    public String getNonporous_has_logo_image_name() {
        return nonporous_has_logo_image_name;
    }

    public String getNonporous_has_logo_image() {
        return nonporous_has_logo_image;
    }

    public boolean isClear_writing_check() {
        return clear_writing_check;
    }

    public String getClear_writing_information() {
        return clear_writing_information;
    }

    public String getClear_writing_image_name() {
        return clear_writing_image_name;
    }

    public String getClear_writing_image() {
        return clear_writing_image;
    }

    public boolean isWood_coated_check() {
        return wood_coated_check;
    }

    public String getWood_coated_information() {
        return wood_coated_information;
    }

    public String getWood_coated_image_name() {
        return wood_coated_image_name;
    }

    public String getWood_coated_image() {
        return wood_coated_image;
    }

    public boolean isDcp_co2_check() {
        return dcp_co2_check;
    }

    public String getDcp_co2_information() {
        return dcp_co2_information;
    }

    public String getDcp_co2_image_name() {
        return dcp_co2_image_name;
    }

    public String getDcp_co2_image() {
        return dcp_co2_image;
    }

    public boolean isGood_condition_check() {
        return good_condition_check;
    }

    public String getGood_condition_information() {
        return good_condition_information;
    }

    public String getGood_condition_image_name() {
        return good_condition_image_name;
    }

    public String getGood_condition_image() {
        return good_condition_image;
    }

    public boolean isWorking_check() {
        return working_check;
    }

    public String getWorking_information() {
        return working_information;
    }

    public String getWorking_image_name() {
        return working_image_name;
    }

    public String getWorking_image() {
        return working_image;
    }

    public boolean isFront_tire_check() {
        return front_tire_check;
    }

    public String getFront_tire_information() {
        return front_tire_information;
    }

    public String getFront_tire_image_name() {
        return front_tire_image_name;
    }

    public String getFront_tire_image() {
        return front_tire_image;
    }

    public boolean isRear_tire_check() {
        return rear_tire_check;
    }

    public String getRear_tire_information() {
        return rear_tire_information;
    }

    public String getRear_tire_image_name() {
        return rear_tire_image_name;
    }

    public String getRear_tire_image() {
        return rear_tire_image;
    }

    public boolean isSteer_max_check() {
        return steer_max_check;
    }

    public String getSteer_max_information() {
        return steer_max_information;
    }

    public String getSteer_max_image_name() {
        return steer_max_image_name;
    }

    public String getSteer_max_image() {
        return steer_max_image;
    }

    public boolean isEasy_steer_check() {
        return easy_steer_check;
    }

    public String getEasy_steer_information() {
        return easy_steer_information;
    }

    public String getEasy_steer_image_name() {
        return easy_steer_image_name;
    }

    public String getEasy_steer_image() {
        return easy_steer_image;
    }

    public boolean isOverall_check() {
        return overall_check;
    }

    public String getOverall_information() {
        return overall_information;
    }

    public String getOverall_image_name() {
        return overall_image_name;
    }

    public String getOverall_image() {
        return overall_image;
    }

    public boolean isEmergency_check() {
        return emergency_check;
    }

    public String getEmergency_information() {
        return emergency_information;
    }

    public String getEmergency_image_name() {
        return emergency_image_name;
    }

    public String getEmergency_image() {
        return emergency_image;
    }

    public boolean isDoor_check() {
        return door_check;
    }

    public String getDoor_information() {
        return door_information;
    }

    public String getDoor_image_name() {
        return door_image_name;
    }

    public String getDoor_image() {
        return door_image;
    }

    public boolean isSpatbor_check() {
        return spatbor_check;
    }

    public String getSpatbor_information() {
        return spatbor_information;
    }

    public String getSpatbor_image_name() {
        return spatbor_image_name;
    }

    public String getSpatbor_image() {
        return spatbor_image;
    }

    public void setInstantiated0(boolean instantiated0) {
        this.instantiated0 = instantiated0;
    }

    public void setInstantiated1(boolean instantiated1) {
        this.instantiated1 = instantiated1;
    }

    public void setInstantiated2(boolean instantiated2) {
        this.instantiated2 = instantiated2;
    }

    public void setInstantiated3(boolean instantiated3) {
        this.instantiated3 = instantiated3;
    }

    public void setInstantiated4(boolean instantiated4) {
        this.instantiated4 = instantiated4;
    }

    public void setInstantiated5(boolean instantiated5) {
        this.instantiated5 = instantiated5;
    }

    public void setInstantiated6(boolean instantiated6) {
        this.instantiated6 = instantiated6;
    }

    public void setInstantiated7(boolean instantiated7) {
        this.instantiated7 = instantiated7;
    }

    public void setInstantiated8(boolean instantiated8) {
        this.instantiated8 = instantiated8;
    }

    public void setInstantiated9(boolean instantiated9) {
        this.instantiated9 = instantiated9;
    }

    public void setInstantiated10(boolean instantiated10) {
        this.instantiated10 = instantiated10;
    }

    public void setInstantiated11(boolean instantiated11) {
        this.instantiated11 = instantiated11;
    }

    public void setInstantiated12(boolean instantiated12) {
        this.instantiated12 = instantiated12;
    }

    public boolean isInstantiated0() {
        return instantiated0;
    }

    public boolean isInstantiated1() {
        return instantiated1;
    }

    public boolean isInstantiated2() {
        return instantiated2;
    }

    public boolean isInstantiated3() {
        return instantiated3;
    }

    public boolean isInstantiated4() {
        return instantiated4;
    }

    public boolean isInstantiated5() {
        return instantiated5;
    }

    public boolean isInstantiated6() {
        return instantiated6;
    }

    public boolean isInstantiated7() {
        return instantiated7;
    }

    public boolean isInstantiated8() {
        return instantiated8;
    }

    public boolean isInstantiated9() {
        return instantiated9;
    }

    public boolean isInstantiated10() {
        return instantiated10;
    }

    public boolean isInstantiated11() {
        return instantiated11;
    }

    public boolean isInstantiated12() {
        return instantiated12;
    }

    public void update0(Audit audit){
        if(audit.isInstantiated0()) {
            instantiated0 = audit.isInstantiated0();
            stnk_check = audit.isStnk_check();
            stnk_valid_date = audit.getStnk_valid_date();
            stnk_information = audit.getStnk_information();
            stnk_image_name = audit.getStnk_image_name();
            stnk_image = audit.getStnk_image();
            llajr_check = audit.isLlajr_check();
            llajr_valid_date = audit.getLlajr_valid_date();
            llajr_information = audit.getLlajr_information();
            llajr_image_name = audit.getLlajr_image_name();
            llajr_image = audit.getLlajr_image();
        }
    }

    public void update1(Audit audit){
        if(audit.isInstantiated1()) {
            instantiated1 = audit.isInstantiated1();
            safety_switch_1_check = audit.isSafety_switch_1_check();
            safety_switch_1_information = audit.getSafety_switch_1_information();
            safety_switch_1_image_name = audit.getSafety_switch_1_image_name();
            safety_switch_1_image = audit.getSafety_switch_1_image();
            safety_switch_2_check = audit.isSafety_switch_2_check();
            safety_switch_2_information = audit.getSafety_switch_2_information();
            safety_switch_2_image_name = audit.getSafety_switch_2_image_name();
            safety_switch_2_image = audit.getSafety_switch_2_image();
            starter_check = audit.isStarter_check();
            starter_information = audit.getStarter_information();
            starter_image_name = audit.getStarter_image_name();
            starter_image = audit.getStarter_image();
        }
    }

    public void update2(Audit audit){
        if(audit.isInstantiated2()) {
            instantiated2 = audit.isInstantiated2();
            bent_check = audit.isBent_check();
            bent_information = audit.getBent_information();
            bent_image_name = audit.getBent_image_name();
            bent_image = audit.getBent_image();
            standard_check = audit.isStandard_check();
            standard_emission = audit.getStandard_emission();
            standard_information = audit.getStandard_information();
            standard_image_name = audit.getStandard_image_name();
            standard_image = audit.getStandard_image();
        }
    }

    public void update3(Audit audit){
        if(audit.isInstantiated3()) {
            instantiated3 = audit.isInstantiated3();
            isolated_check = audit.isolated_check();
            isolated_information = audit.getIsolated_information();
            isolated_image_name = audit.getIsolated_image_name();
            isolated_image = audit.getIsolated_image();
            fuse_original_check = audit.isFuse_original_check();
            fuse_original_information = audit.getFuse_original_information();
            fuse_original_image_name = audit.getFuse_original_image_name();
            fuse_original_image = audit.getFuse_original_image();
        }
    }

    public void update4(Audit audit){
        if(audit.isInstantiated4()) {
            instantiated4 = audit.isInstantiated4();
            well_maintained_check = audit.isWell_maintained_check();
            well_maintained_information = audit.getWell_maintained_information();
            well_maintained_image_name = audit.getWell_maintained_image_name();
            well_maintained_image = audit.getWell_maintained_image();
            well_installed_check = audit.isWell_installed_check();
            well_installed_information = audit.getWell_installed_information();
            well_installed_image_name = audit.getWell_installed_image_name();
            well_installed_image = audit.getWell_installed_image();
        }
    }

    public void update5(Audit audit){
        if(audit.isInstantiated5()) {
            instantiated5 = audit.isInstantiated5();
            light_on_closed_check = audit.isLight_on_closed_check();
            light_on_closed_information = audit.getLight_on_closed_information();
            light_on_closed_image_name = audit.getLight_on_closed_image_name();
            light_on_closed_image = audit.getLight_on_closed_image();
            light_overall_check = audit.isLight_overall_check();
            light_overall_information = audit.getLight_overall_information();
            light_overall_image_name = audit.getLight_overall_image_name();
            light_overall_image = audit.getLight_overall_image();
        }
    }

    public void update6(Audit audit){
        if(audit.isInstantiated6()) {
            instantiated6 = audit.isInstantiated6();
            nonporous_has_logo_check = audit.isNonporous_has_logo_check();
            nonporous_has_logo_information = audit.getNonporous_has_logo_information();
            nonporous_has_logo_image_name = audit.getNonporous_has_logo_image_name();
            nonporous_has_logo_image = audit.getNonporous_has_logo_image();
            clear_writing_check = audit.isClear_writing_check();
            clear_writing_information = audit.getClear_writing_information();
            clear_writing_image_name = audit.getClear_writing_image_name();
            clear_writing_image = audit.getClear_writing_image();
            wood_coated_check = audit.isWood_coated_check();
            wood_coated_information = audit.getWood_coated_information();
            wood_coated_image_name = audit.getWood_coated_image_name();
            wood_coated_image = audit.getWood_coated_image();
        }
    }

    public void update7(Audit audit){
        if(audit.isInstantiated7()) {
            instantiated7 = audit.isInstantiated7();
            dcp_co2_check = audit.isDcp_co2_check();
            dcp_co2_information = audit.getDcp_co2_information();
            dcp_co2_image_name = audit.getDcp_co2_image_name();
            dcp_co2_image = audit.getDcp_co2_image();
            good_condition_check = audit.isGood_condition_check();
            good_condition_information = audit.getGood_condition_information();
            good_condition_image_name = audit.getGood_condition_image_name();
            good_condition_image = audit.getGood_condition_image();
        }
    }

    public void update8(Audit audit){
        if(audit.isInstantiated8()) {
            instantiated8 = audit.isInstantiated8();
            working_check = audit.isWorking_check();
            working_information = audit.getWorking_information();
            working_image_name = audit.getWorking_image_name();
            working_image = audit.getWorking_image();
        }
    }

    public void update9(Audit audit){
        if(audit.isInstantiated9()) {
            instantiated9 = audit.isInstantiated9();
            front_tire_check = audit.isFront_tire_check();
            front_tire_information = audit.getFront_tire_information();
            front_tire_image_name = audit.getFront_tire_image_name();
            front_tire_image = audit.getFront_tire_image();
            rear_tire_check = audit.isRear_tire_check();
            rear_tire_information = audit.getRear_tire_information();
            rear_tire_image_name = audit.getRear_tire_image_name();
            rear_tire_image = audit.getRear_tire_image();
        }
    }

    public void update10(Audit audit){
        if(audit.isInstantiated10()) {
            instantiated10 = audit.isInstantiated10();
            steer_max_check = audit.isSteer_max_check();
            steer_max_information = audit.getSteer_max_information();
            steer_max_image_name = audit.getSteer_max_image_name();
            steer_max_image = audit.getSteer_max_image();
            easy_steer_check = audit.isEasy_steer_check();
            easy_steer_information = audit.getEasy_steer_information();
            easy_steer_image_name = audit.getEasy_steer_image_name();
            easy_steer_image = audit.getEasy_steer_image();
        }
    }

    public void update11(Audit audit){
        if(audit.isInstantiated11()) {
            instantiated11 = audit.isInstantiated11();
            overall_check = audit.isOverall_check();
            overall_information = audit.getOverall_information();
            overall_image_name = audit.getOverall_image_name();
            overall_image = audit.getOverall_image();
        }
    }

    public void update12(Audit audit){
        if(audit.isInstantiated12()) {
            instantiated12 = audit.isInstantiated12();
            emergency_check = audit.isEmergency_check();
            emergency_information = audit.getEmergency_information();
            emergency_image_name = audit.getEmergency_image_name();
            emergency_image = audit.getEmergency_image();
            door_check = audit.isDoor_check();
            door_information = audit.getDoor_information();
            door_image_name = audit.getDoor_image_name();
            door_image = audit.getDoor_image();
            spatbor_check = audit.isSpatbor_check();
            spatbor_information = audit.getSpatbor_information();
            spatbor_image_name = audit.getSpatbor_image_name();
            spatbor_image = audit.getSpatbor_image();
        }
    }
}
