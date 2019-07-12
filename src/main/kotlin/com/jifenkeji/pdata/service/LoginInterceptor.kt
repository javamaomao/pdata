package com.jifenkeji.pdata.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.lang.Nullable
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginInterceptor : HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        log.info("---------------------开始进入请求地址拦截----------------------------")
        println(request.requestURI)
        return true

    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable
    modelAndView: ModelAndView?) {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------")
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable
    e: java.lang.Exception?) {
        log.info("---------------视图渲染之后的操作-------------------------0")
    }

    companion object {

        private val log = LoggerFactory.getLogger(LoginInterceptor::class.java)
    }

}