<template>
  <el-dialog
    :title="!dataForm.attrId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="å±žæ€§å" prop="attrName">
      <el-input v-model="dataForm.attrName" placeholder="å±žæ€§å"></el-input>
    </el-form-item>
    <el-form-item label="æ˜¯å¦éœ€è¦æ£€ç´¢[0-ä¸éœ€è¦ï¼Œ1-éœ€è¦]" prop="searchType">
      <el-input v-model="dataForm.searchType" placeholder="æ˜¯å¦éœ€è¦æ£€ç´¢[0-ä¸éœ€è¦ï¼Œ1-éœ€è¦]"></el-input>
    </el-form-item>
    <el-form-item label="å±žæ€§å›¾æ ‡" prop="icon">
      <el-input v-model="dataForm.icon" placeholder="å±žæ€§å›¾æ ‡"></el-input>
    </el-form-item>
    <el-form-item label="å¯é€‰å€¼åˆ—è¡¨[ç”¨é€—å·åˆ†éš”]" prop="valueSelect">
      <el-input v-model="dataForm.valueSelect" placeholder="å¯é€‰å€¼åˆ—è¡¨[ç”¨é€—å·åˆ†éš”]"></el-input>
    </el-form-item>
    <el-form-item label="å±žæ€§ç±»åž‹[0-é”€å”®å±žæ€§ï¼Œ1-åŸºæœ¬å±žæ€§ï¼Œ2-æ—¢æ˜¯é”€å”®å±žæ€§åˆæ˜¯åŸºæœ¬å±žæ€§]" prop="attrType">
      <el-input v-model="dataForm.attrType" placeholder="å±žæ€§ç±»åž‹[0-é”€å”®å±žæ€§ï¼Œ1-åŸºæœ¬å±žæ€§ï¼Œ2-æ—¢æ˜¯é”€å”®å±žæ€§åˆæ˜¯åŸºæœ¬å±žæ€§]"></el-input>
    </el-form-item>
    <el-form-item label="å¯ç”¨çŠ¶æ€[0 - ç¦ç”¨ï¼Œ1 - å¯ç”¨]" prop="enable">
      <el-input v-model="dataForm.enable" placeholder="å¯ç”¨çŠ¶æ€[0 - ç¦ç”¨ï¼Œ1 - å¯ç”¨]"></el-input>
    </el-form-item>
    <el-form-item label="æ‰€å±žåˆ†ç±»" prop="catelogId">
      <el-input v-model="dataForm.catelogId" placeholder="æ‰€å±žåˆ†ç±»"></el-input>
    </el-form-item>
    <el-form-item label="å¿«é€Ÿå±•ç¤ºã€æ˜¯å¦å±•ç¤ºåœ¨ä»‹ç»ä¸Šï¼›0-å¦ 1-æ˜¯ã€‘ï¼Œåœ¨skuä¸­ä»ç„¶å¯ä»¥è°ƒæ•´" prop="showDesc">
      <el-input v-model="dataForm.showDesc" placeholder="å¿«é€Ÿå±•ç¤ºã€æ˜¯å¦å±•ç¤ºåœ¨ä»‹ç»ä¸Šï¼›0-å¦ 1-æ˜¯ã€‘ï¼Œåœ¨skuä¸­ä»ç„¶å¯ä»¥è°ƒæ•´"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          attrId: 0,
          attrName: '',
          searchType: '',
          icon: '',
          valueSelect: '',
          attrType: '',
          enable: '',
          catelogId: '',
          showDesc: ''
        },
        dataRule: {
          attrName: [
            { required: true, message: 'å±žæ€§å不能为空', trigger: 'blur' }
          ],
          searchType: [
            { required: true, message: 'æ˜¯å¦éœ€è¦æ£€ç´¢[0-ä¸éœ€è¦ï¼Œ1-éœ€è¦]不能为空', trigger: 'blur' }
          ],
          icon: [
            { required: true, message: 'å±žæ€§å›¾æ ‡不能为空', trigger: 'blur' }
          ],
          valueSelect: [
            { required: true, message: 'å¯é€‰å€¼åˆ—è¡¨[ç”¨é€—å·åˆ†éš”]不能为空', trigger: 'blur' }
          ],
          attrType: [
            { required: true, message: 'å±žæ€§ç±»åž‹[0-é”€å”®å±žæ€§ï¼Œ1-åŸºæœ¬å±žæ€§ï¼Œ2-æ—¢æ˜¯é”€å”®å±žæ€§åˆæ˜¯åŸºæœ¬å±žæ€§]不能为空', trigger: 'blur' }
          ],
          enable: [
            { required: true, message: 'å¯ç”¨çŠ¶æ€[0 - ç¦ç”¨ï¼Œ1 - å¯ç”¨]不能为空', trigger: 'blur' }
          ],
          catelogId: [
            { required: true, message: 'æ‰€å±žåˆ†ç±»不能为空', trigger: 'blur' }
          ],
          showDesc: [
            { required: true, message: 'å¿«é€Ÿå±•ç¤ºã€æ˜¯å¦å±•ç¤ºåœ¨ä»‹ç»ä¸Šï¼›0-å¦ 1-æ˜¯ã€‘ï¼Œåœ¨skuä¸­ä»ç„¶å¯ä»¥è°ƒæ•´不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.attrId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.attrId) {
            this.$http({
              url: this.$http.adornUrl(`/product/attr/info/${this.dataForm.attrId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.attrName = data.attr.attrName
                this.dataForm.searchType = data.attr.searchType
                this.dataForm.icon = data.attr.icon
                this.dataForm.valueSelect = data.attr.valueSelect
                this.dataForm.attrType = data.attr.attrType
                this.dataForm.enable = data.attr.enable
                this.dataForm.catelogId = data.attr.catelogId
                this.dataForm.showDesc = data.attr.showDesc
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/product/attr/${!this.dataForm.attrId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'attrId': this.dataForm.attrId || undefined,
                'attrName': this.dataForm.attrName,
                'searchType': this.dataForm.searchType,
                'icon': this.dataForm.icon,
                'valueSelect': this.dataForm.valueSelect,
                'attrType': this.dataForm.attrType,
                'enable': this.dataForm.enable,
                'catelogId': this.dataForm.catelogId,
                'showDesc': this.dataForm.showDesc
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
