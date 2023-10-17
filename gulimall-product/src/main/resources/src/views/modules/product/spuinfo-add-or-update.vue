<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="å•†å“åç§°" prop="spuName">
      <el-input v-model="dataForm.spuName" placeholder="å•†å“åç§°"></el-input>
    </el-form-item>
    <el-form-item label="å•†å“æè¿°" prop="spuDescription">
      <el-input v-model="dataForm.spuDescription" placeholder="å•†å“æè¿°"></el-input>
    </el-form-item>
    <el-form-item label="æ‰€å±žåˆ†ç±»id" prop="catalogId">
      <el-input v-model="dataForm.catalogId" placeholder="æ‰€å±žåˆ†ç±»id"></el-input>
    </el-form-item>
    <el-form-item label="å“ç‰Œid" prop="brandId">
      <el-input v-model="dataForm.brandId" placeholder="å“ç‰Œid"></el-input>
    </el-form-item>
    <el-form-item label="" prop="weight">
      <el-input v-model="dataForm.weight" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="ä¸Šæž¶çŠ¶æ€[0 - ä¸‹æž¶ï¼Œ1 - ä¸Šæž¶]" prop="publishStatus">
      <el-input v-model="dataForm.publishStatus" placeholder="ä¸Šæž¶çŠ¶æ€[0 - ä¸‹æž¶ï¼Œ1 - ä¸Šæž¶]"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
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
          id: 0,
          spuName: '',
          spuDescription: '',
          catalogId: '',
          brandId: '',
          weight: '',
          publishStatus: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          spuName: [
            { required: true, message: 'å•†å“åç§°不能为空', trigger: 'blur' }
          ],
          spuDescription: [
            { required: true, message: 'å•†å“æè¿°不能为空', trigger: 'blur' }
          ],
          catalogId: [
            { required: true, message: 'æ‰€å±žåˆ†ç±»id不能为空', trigger: 'blur' }
          ],
          brandId: [
            { required: true, message: 'å“ç‰Œid不能为空', trigger: 'blur' }
          ],
          weight: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          publishStatus: [
            { required: true, message: 'ä¸Šæž¶çŠ¶æ€[0 - ä¸‹æž¶ï¼Œ1 - ä¸Šæž¶]不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/product/spuinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.spuName = data.spuInfo.spuName
                this.dataForm.spuDescription = data.spuInfo.spuDescription
                this.dataForm.catalogId = data.spuInfo.catalogId
                this.dataForm.brandId = data.spuInfo.brandId
                this.dataForm.weight = data.spuInfo.weight
                this.dataForm.publishStatus = data.spuInfo.publishStatus
                this.dataForm.createTime = data.spuInfo.createTime
                this.dataForm.updateTime = data.spuInfo.updateTime
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
              url: this.$http.adornUrl(`/product/spuinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'spuName': this.dataForm.spuName,
                'spuDescription': this.dataForm.spuDescription,
                'catalogId': this.dataForm.catalogId,
                'brandId': this.dataForm.brandId,
                'weight': this.dataForm.weight,
                'publishStatus': this.dataForm.publishStatus,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
