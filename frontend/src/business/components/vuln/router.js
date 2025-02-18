/* eslint-disable */
export default {
  name: "Vuln",
  path: "/vuln",
  redirect: "/vuln/vuln",
  components: {
    content: () => import(/* webpackChunkName: "setting" */ '@/business/components/vuln/base')
  },
  children: [
    {
      path: "vuln",
      name: "vuln",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/vuln/home/Vuln'),
    },
    {
      path: "rule",
      name: "vulnRule",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/vuln/home/Rule'),
    },
    {
      path: "result",
      name: "vulnResult",
      component: () => import(/* webpackChunkName: "api" */ '@/business/components/vuln/home/Result'),
    },
    {
      path: "resultdetails/:id",
      name: "vulnResultdetails",
      component: () => import(/* webpackChunkName: "api" */ "@/business/components/vuln/home/ResultDetails"),
    },
  ]
}
