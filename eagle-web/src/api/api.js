import axiosIns from './axios-ins'
import axiosForm from './axios-form'
import * as url from './url'

export function logout() {
  return axiosIns.get(url.LOG_OUT);
}

export function login(user) {
  return axiosForm.post(url.LOGIN, user);
}

export function isOnline() {
  return axiosIns.get(url.IS_ONLINE);
}

export function getUserList(json) {
  return axiosIns.post(url.GET_USER_LIST, json);
}

export function getUserMessage(json) {
  return axiosIns.post(url.GET_USER_MESSAGES, json);
}

export function getMessage(userId, otherUserId, time, json) {
  return axiosIns.post(url.GET_MESSAGES + "/" + userId + "/" + otherUserId + "/" + time, json);
}


export function getEssay(json) {
  return axiosIns.post(url.GET_ESSAY, json);
}


export function getCommentByEssayId(id, json) {
  return axiosIns.post(url.GET_ESSAY_COMMENT + id, json);
}

export function getEmployeeList(json) {
  return axiosIns.post(url.GET_EMPLOYEE_LIST, json);
}

export function saveUpdateEmployee(json) {
  return axiosIns.post(url.SAVE_UPDATE_EMPLOYEE, json);
}


export function getRoleList(json) {
  return axiosIns.post(url.GET_ROLE_LIST, json);
}

export function saveUpdateRole(json) {
  return axiosIns.post(url.SAVE_UPDATE_ROLE, json);
}

export function roleDelete(id) {
  return axiosIns.get(url.ROLE_DELETE + id);
}

export function employeeDelete(id) {
  return axiosIns.get(url.EMPLOYEE_DELETE + id);
}

export function employeeAssignRole(json) {
  return axiosIns.post(url.EMPLOYEE_ASSIGN_ROLE, json);
}

export function permissionList() {
  return axiosIns.get(url.PERMISSION_LIST);
}

export function assignPerm(json) {
  return axiosIns.post(url.ASSIGN_PERM, json);
}

export function getOrderList(json) {
  return axiosIns.post(url.GET_ORDER_LIST, json);
}

export function getExportList(json) {
  return axiosIns.post(url.GET_EXPORT_LIST, json);
}

export function getOrderDetail(json) {
  return axiosIns.post(url.GET_ORDER_DETAIL, json);
}

export function saveOrder(json) {
  return axiosIns.put(url.SAVE_ORDER, json);
}

export function updateOrder(json) {
  return axiosIns.put(url.UPDATE_ORDER, json);
}

export function deleteOrder(json) {
  return axiosIns.delete(url.DELETE_ORDER, json);
}

export function getIdByOrderNo(json) {
  return axiosIns.post(url.GET_ID_BY_ORDER_NO, json)
}

export function getClientList(json) {
  return axiosIns.post(url.GET_CLIENT_LIST, json);
}

export function getClientDetail(json) {
  return axiosIns.post(url.GET_CLIENT_DETAIL, json);
}

export function saveClient(json) {
  return axiosIns.put(url.SAVE_CLIENT, json);
}

export function updateClient(json) {
  return axiosIns.put(url.UPDATE_CLIENT, json);
}

export function deleteClient(json) {
  return axiosIns.put(url.DELETE_CLIENT, json);
}

export function getGoodsList(json) {
  return axiosIns.post(url.GET_GOODS_LIST, json);
}

export function getGoodsDetail(json) {
  return axiosIns.post(url.GET_GOODS_DETAIL, json);
}

export function saveGoods(json) {
  return axiosIns.put(url.SAVE_GOODS, json);
}

export function updateGoods(json) {
  return axiosIns.put(url.UPDATE_GOODS, json);
}

export function deleteGoods(json) {
  return axiosIns.put(url.DELETE_GOODS, json);
}

export function getTransferCompanyList(json) {
  return axiosIns.post(url.GET_TRANSFER_COMPANY_LIST, json);
}

export function getTransferCoDetail(json) {
  return axiosIns.post(url.GET_TRANSFER_CO_DETAIL, json);
}

export function saveTransferCo(json) {
  return axiosIns.put(url.SAVE_TRANSFER_CO, json);
}

export function updateTransferCo(json) {
  return axiosIns.put(url.UPDATE_TRANSFER_CO, json);
}

export function deleteTransferCo(json) {
  return axiosIns.put(url.DELETE_TRANSFER_CO, json);
}

export function getClientInfoList() {
  return axiosIns.get(url.GET_CLIENT_INFO_LIST);
}

export function getTransferCoInfoList() {
  return axiosIns.get(url.GET_TRANSFER_CO_INFO_LIST);
}

export function getGoodsInfoList() {
  return axiosIns.get(url.GET_GOODS_INFO_LIST);
}

export function getSalesmanList(json) {
  return axiosIns.post(url.GET_SALESMAN_LIST, json);
}

export function getSalesmanDetail(json) {
  return axiosIns.post(url.GET_SALESMAN_DETAIL, json);
}

export function saveSalesman(json) {
  return axiosIns.put(url.SAVE_SALESMAN, json);
}

export function updateSalesman(json) {
  return axiosIns.put(url.UPDATE_SALESMAN, json);
}

export function getSalesmanInfoList() {
  return axiosIns.get(url.GET_SALESMAN_INFO_LIST);
}

export function getSalesmanIdByClientId(json) {
  return axiosIns.post(url.GET_SALESMAN_ID_BY_CLIENT, json);
}

export function getDestination() {
  return axiosIns.get(url.GET_DESTINATION);
}

export function getTaskList(id) {
  return axiosIns.post(url.GET_TASK_LIST, id);
}

export function getTaskDetail(json) {
  return axiosIns.get(url.ORDER_TASK + '/' + json);
}

export function saveTask(json) {
  return axiosIns.post(url.ORDER_TASK, json);
}

export function deleteTask(json) {
  return axiosIns.delete(url.ORDER_TASK + '/' + json);
}

export function updateTask(id, json) {
  return axiosIns.put(url.ORDER_TASK + '/' + id, json);
}

export function updateTaskStatus(json) {
  return axiosIns.post(url.UPDATE_TASK_STATUS, json);
}

export function getUnFinishTask() {
  return axiosIns.get(url.GET_UN_FINISH_TASK);
}


