package com.athena.mvc;

import com.athena.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaoxiang.zhang
 * @Description:请求分发类
 * @Date: Create in 7:29 PM 2019/11/28
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    @Override
    public void init() throws ServletException {
        Class<?> memeberControllerClazz = MemberController.class;
        try {
            handlerMapping.add(new Handler().setController(memeberControllerClazz.newInstance())
                    .setMethod(memeberControllerClazz.getMethod("getMemberById", new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成调度
        //doDispatch(req, resp);
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        try {
            Object obj = handler.getMethod().invoke(handler.getController(), req.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /*private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if ("getMemberById".equals(uri)) {
            new MemberController().getMemberById(mid);
        } else if ("getOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        } else if ("logout".equals(uri)) {
            new SystemController().logout(mid);
        } else {
            try {
                resp.getWriter().write("404 Not Found!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    class Handler {
        private Object controller;

        private Method method;

        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
