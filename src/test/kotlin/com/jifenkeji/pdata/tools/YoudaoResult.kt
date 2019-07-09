package com.jifenkeji.pdata.tools

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class YoudaoResult(
        @JsonProperty("tSpeakUrl") val tSpeakUrl: String?,
        @JsonProperty("web") val web: List<Web?>?,
        @JsonProperty("query") val query: String?,
        @JsonProperty("translation") val translation: List<String?>?,
        @JsonProperty("errorCode") val errorCode: String?,
        @JsonProperty("dict") val dict: Dict?,
        @JsonProperty("webdict") val webdict: Webdict?,
        @JsonProperty("basic") val basic: Basic?,
        @JsonProperty("l") val l: String?,
        @JsonProperty("speakUrl") val speakUrl: String?,
        @JsonProperty("returnPhrase") val returnPhrase: List<String>?
) {

    data class Dict(
            @JsonProperty("url") val url: String?
    )


    data class Web(
            @JsonProperty("value") val value: List<String?>?,
            @JsonProperty("key") val key: String?
    )


    data class Webdict(
            @JsonProperty("url") val url: String?
    )


    data class Basic(
            @JsonProperty("exam_type") val examType: List<String?>?,
            @JsonProperty("us-phonetic") val usPhonetic: String?,
            @JsonProperty("phonetic") val phonetic: String?,
            @JsonProperty("uk-phonetic") val ukPhonetic: String?,
            @JsonProperty("uk-speech") val ukSpeech: String?,
            @JsonProperty("explains") val explains: List<String?>?,
            @JsonProperty("us-speech") val usSpeech: String?
    )
}